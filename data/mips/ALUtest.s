## MIPS Practice Code
# Testing basic ALU operations with write to registers

# Test add immediates (store reg value in register for 1-4)
addi	$1, $0, 1			# $0 = $1 + 4
addi	$10, $0, 10			
addi	$2, $0, 2			
addi	$3, $0, 3
addi	$4, $0, 4
addi	$5, $0, 5
addi	$6, $0, 6
addi	$7, $0, 7
addi	$8, $0, 8
addi	$9, $0, 9			

# Test add using stored values in registers
add 	$11, $1, $10		# $t0 = $t1+ $t2
add 	$12, $2, $10
add 	$13, $3, $10
add 	$14, $4, $10
add 	$15, $5, $10
