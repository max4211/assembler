## MIPS Practice Code
# Testing basic ALU operations with write to registers

# Test add immediates (store reg value in register for 1-4)
addi	$1, $0, 1			# $0 = $1 + 4	
addi	$2, $0, 2	
addi	$3, $0, 3	
addi	$4, $0, 4	
addi	$5, $0, 5
addi	$6, $0, 4	
addi	$7, $0, 4	
addi	$8, $0, 4	
addi	$9, $0, 4	

# Take a branch
bne		$1, $2, -2 	    # if 
blt		$1, $2, 0	# if $1 < $2 t0 target


add	    $6, $6, $2	

j		0				# jump to 0




