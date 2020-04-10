## MIPS Practice Code
# Decoding of given hex file into MIPS instructions

00101|00001|0000100000000000001010
2842000a 
addi	$1, $1, 10			

00101|00010|0001000000000000000110
28840006 
addi	$2, $2, 6			

00101|00011|0001100000000000001100
28c6000c 
addi	$3, $3, 12			# $3 = $3 + 12

00101|00100|0010011111111111111011
2909fffb 
addi	$4, $4, -5			# $4 = $4 + 0

00000|00101|00001|00010|00000|00010|00
1422008 
and     $5, $1, $2     

00000|00110|00010|00011|00000|00011|00
184300c 
or      $6, $2, $3

00110|00001|00010|00000000000000001
30440001 
blt		$1, $2, 1	# if $1 < $2 then target
# GOTO PC = PC + 1 + 1 (false, b/c $1 > $2)

00001|00000|0000000000000000001101
800000d 
j		13				# jump to target
# THIS JUMP SHOULD OCCUR, WHEN THIS OCCURS, EARLIER PIPELINE IS FLUSHED!!
# HYPOTHESIS: JUMP OCCURS, BUT ADDI ALSO OCCURS? MAKE SURE ADDI IS FLUSHED! (forgotten)

00101|00111|00111|00000000011001000
29ce00c8 
addi	$7, $7, 200			# $7 = $t1 + 0

00010|00001|00000|11111111111111111
1041ffff 
bne		$1, $0, -1	# if $1 != $t1 then target
# THIS WILL BE AN INFINITE LOOP! (according to ISA)

00101|00111|00111|00000000100101100
29ce012c 
addi	$7, $7, 300			# $7 = $7 + 0

00010|00001|00000|11111111111111111
1041ffff 
bne		$1, $0, -1	# if $1 != $0 then -1
# ANOTHER INFINITE LOOP!!! (will this execute?)
# SHOULD THIS BE INFINITE LOOP?


## Expanded code (jumps taken)

000
000
000

2842000a 
addi	$1, $1, 10			

28840006 
addi	$2, $2, 6			

28c6000c 
addi	$3, $3, 12			# $3 = $3 + 12

2909fffb 
addi	$4, $4, -5			# $4 = $4 + 0

1422008 
and     $5, $1, $2     

184300c 
or      $6, $2, $3

30440001 
blt		$1, $2, 1	# if $1 < $2 then target

800000d 
j		13				# jump to target

29ce012c 
addi	$7, $7, 300			# $7 = $7 + 0 (PC = 13)

1041ffff 
bne		$1, $0, -1	# if $1 != $0 then -1
