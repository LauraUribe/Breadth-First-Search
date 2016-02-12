// LAURA URIBE
// OS, HWK 2
// SEGEV

#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <sys/wait.h>
#include <time.h>

// calc checksum of file inputted, compare checksum segev got from same files

// main declaration accepts command line arguments
// argc is the number of arguments passed into program from command line
// argv[] = user inputs 

int main(int argc, char *argv[])
{
	// initialize clock
	clock_t start_t, end_t, total_t;
	
	// segev will input a file
	// i must open and read this file
	int file = open(argv[1], O_RDONLY);
	
	// segev will also input a string number on number of processes
	// take argument 2 and convert it from string to int
	int num_processes = atoi(argv[2]);
	
	// key file size
	struct stat fileStat_key;
	fstat(file, &fileStat_key);
	int file_size = fileStat_key.st_size;
 
	// create chunks based on number of processes segev inputs
	int chunk = file_size/num_processes;
	// if file_size is not evenly divisible by num_processes, then....
	int remainder = file_size%num_processes;  // % is mod in c
		
	unsigned char buffer[chunk];   // every byte of chunk
	unsigned char processes[num_processes];  // 	
	int status = 0;  // return status....que
	
		
	// create processes based on variable num_processes
	pid_t pid;  // set data type of process ID variable
	
	// initializing variable 
	// set it to zero and it will change once this code runs through, 
	// then it will be compared to segev's checksum final result as well
	int checksum = 0;
	
	// make i and j global variables
	int i = 0;
	int j = 0;
	
	start_t = clock();  // start clock, right before forking (elapsed time forking children)
	// fork as many times as num_processes says to...
	for(i = 0; i < num_processes; i++)
	{
		file = open(argv[1], O_RDONLY);
		pid = fork();  // return number that says whether created child process
		
			if (pid == 0)  // if fork() returns 0, then child process created
			{	
				if (num_processes == 1)
				{
					// read in file so for loop gets access to the file
					read(file, buffer, chunk);
				}
				else
				{
					// find beginning of each chunk where each process has n chunks
					// SEEK_SET = says to start at i * chunk next time you look for position
					lseek(file, i * chunk, SEEK_SET);
					// chunk is at first 0, due to initialization...now this will change...
					if (i == num_processes - 1)
					{
						// last process handles whatever data is left
						// this has been caused by the lack of even divisibility
						chunk = chunk + remainder;
					}
						// read in file so for loop gets access to the file
						read(file, buffer, chunk);
				}		
						for (j = 0; j < chunk; j++)  // go through each chunk
						{
								// xor each byte of the chunk with checksum
								// chunk is 5, j is num 1 - 5, meaning the bytes that make up each chunk
								checksum ^= buffer[j];  // j is what byte i am on; buffer[] contains content of file
								// checksum number stays saved in checksum so it works to loop
						}
						close (file);
						// get checksum number of each chunk
						exit(checksum);  // checksum for particular process
						// when checksum is exited, it automatically puts the return number inside the address space of status (allegedly)
						// wait until hit exit status in program
				
			}
		}
	
		end_t = clock();  // end of clock
		total_t = (end_t - start_t); // total time it took for all processes to be run
	
		
	// while loop to xor all the checksums and get a final checksum
	while ((pid = wait(&status)) > 0)  // waiting until the address space of status get the exit number
	{
		processes[i] = WEXITSTATUS(status);  // putting the checksum that is in the status variable, into the process array
		// xor all the checksum's in the array
		checksum ^= processes[i]; 
	}
	printf("Total clock time: %ld\n", total_t);
	printf("Checksum is: %d\n", checksum);
	return 0;
}
