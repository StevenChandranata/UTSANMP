<?php
    include 'connection.php';

    extract($_POST);

    $sql = "INSERT INTO user (username, firstname, lastname, email, password, imageProfil) VALUES (?, ?, ?, ?, ?,?)";
    $stmt = $conn->prepare($sql);

    $stmt->bind_param("ssssss", $username, $firstname, $lastname, $email, $password, $imageProfil);

    if ($stmt->execute()) {
        echo "New user inserted successfully";
    } else {
        echo "Error" . $conn->error;
    }

    echo json_encode($arr);
    $stmt->close();
    $conn->close();
?>

