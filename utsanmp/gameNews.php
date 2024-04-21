<?php
include 'connection.php';
$idgame = isset($_GET["idgame"]) ? intval($_GET["idgame"]) : null;
$sql = "SELECT game.idgame, game.title, game.description, game.imageUrl, user.username as creatorUsername
        FROM game 
        INNER JOIN user ON game.user_id = user.id";
if ($idgame !== null) {
    $sql .= " WHERE game.idgame = ?";
}
$stmt = $conn->prepare($sql);
if ($stmt) {
    if ($idgame !== null) {
        $stmt->bind_param("i", $idgame);
    }
    $stmt->execute();
    $result = $stmt->get_result();
    if ($result) {
        $games = array();
        while ($row = $result->fetch_assoc()) {
            $game = $row;
            $sql_detail = "SELECT descriptiondetail FROM gamedetail WHERE idgame = ?";
            $stmt_detail = $conn->prepare($sql_detail);
            $stmt_detail->bind_param("i", $game['idgame']);
            $stmt_detail->execute();
            $result_detail = $stmt_detail->get_result();
            
            $details = array();
            while ($row_detail = $result_detail->fetch_assoc()) {
                $details[] = $row_detail['descriptiondetail'];
            }
            $game['descriptiondetail'] = $details;
            $games[] = $game;
        }
        echo json_encode($games);
    } else {
        echo json_encode(array("message" => "No games found"));
    }
    $stmt->close();
    if (isset($stmt_detail)) {
        $stmt_detail->close();
    }
} else {
    echo json_encode(array("error" => $conn->error));
}
$conn->close();
?>
