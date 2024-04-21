<?php
include 'connection.php';

extract($_POST);

$sql = "UPDATE user SET firstname=?, lastname=?, password=? WHERE username=?";
$stmt = $conn->prepare($sql);

if ($stmt) {
    $stmt->bind_param("ssss", $firstname, $lastname, $password, $username);
    if ($stmt->execute()) {
        echo "User information updated successfully";
    } else {
        echo "Error: " . $conn->error;
    }
    $stmt->close();
} else {
    echo "Error: Unable to prepare statement";
}

$conn->close();
?>

