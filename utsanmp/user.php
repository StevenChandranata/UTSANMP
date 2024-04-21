<?php
include 'connection.php';

$sql = "SELECT * FROM user";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
    $user_data = array();
    while ($row = $result->fetch_assoc()) {
        $user_data[] = $row;
    }
    echo json_encode($user_data);
}

$conn->close();
?>

