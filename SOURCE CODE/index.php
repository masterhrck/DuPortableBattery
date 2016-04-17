<?php
	$id = $_GET["id"];
	$percent = $_GET["percent"];
	$state = $_GET["state"];
	$giveAll = false;
	//$giveAll = $_GET["giveAll"];
	if (empty($_GET['giveAll'])){
		$giveAll = false;
	}
	else{
		$giveAll = $_GET["giveAll"];
	}

	
	$servername = "localhost:3306";
	$username = "root";
	$password = "";
	
	
	// Create connection
	$conn = new mysqli($servername, $username, $password, "bat");
	
	if (!$conn) {
    die("Connection failed: " . mysqli_connect_error());
	}

	if($giveAll){
		$sql = "SELECT *  FROM state";
	}
	else{
		$time = date_create();
		date_timestamp_set($time, time());
		$sql = "INSERT INTO state (id, percent, state) VALUES($id, $percent, $state) ON DUPLICATE KEY UPDATE percent=$percent, state=$state";
	}
	
	$result = mysqli_query($conn, $sql);
	//mysqli_num_rows($result) > 0
	if (true) {
		if(!$giveAll){
			echo "New record created successfully";
		}else {
			$rows = array();
			
			while($r = mysqli_fetch_assoc($result)) {
				$rows[] = $r;
			}
			echo json_encode($rows);
		}
} else {
    echo "Error: " . $sql . "<br>" . $conn->error;
}
	
	$conn->close();
?>