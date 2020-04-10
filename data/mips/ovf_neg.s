addi	$1, $0, -2	
addi    $2, $0, 2 		

# Shift values left
sll     $10, $1, 29
sll     $11, $2, 29

# Add values
sub		$10, $11, $10		
bne		$1, $2, -2
		

