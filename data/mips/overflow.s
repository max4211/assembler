addi	$1, $0, 1				
addi	$2, $0, 2			
addi	$3, $0, 3
addi	$4, $0, 4
addi	$5, $0, 5
addi	$6, $0, 6
addi	$7, $0, 7
addi	$8, $0, 8			

# Shift values left
sll     $10, $1, 29

# Add values
add		$10, $10, $10		
bne		$1, $2, -2
		

