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
#include <pthread.h>
#include <semaphore.h>

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
	int num_threads = atoi(argv[2]);
	
	// key file size
	struct stat fileStat_key;
	fstat(file, &fileStat_key);
	int file_size = fileStat_key.st_size;
 
	// create chunks based on number of threads segev inputs
	int chunk = file_size/num_threads;
	// if file_size is not evenly divisible by num_threads, then....
	int remainder = file_size%num_threads;  // % is mod in c
		
	unsigned char buffer[chunk];   // every byte of chunk
	unsigned char threads[num_threads];  // 	
	// int status = 0;  // return status....que
	
		
	// create processes based on variable num_processes
	pthread_t tid;  // set data type of process ID variable
	
	// initializing variable 
	// set it to zero and it will change once this code runs through, 
	// then it will be compared to segev's checksum final result as well
	int checksum = 0;
	
	// make i and j global variables
	int i = 0;
	int j = 0;
	
	start_t = clock();  // start clock
	// fork as many times as num_processes says to...
	for(i = 0; i < num_threads; i++)
	{
		file = open(argv[1], O_RDONLY);
		
				if (num_threads == 1)
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
					if (i == num_threads - 1)
					{
						// last process handles whatever data is left
						// this has been caused by the lack of even divisibility
						chunk = chunk + remainder;
					}
						// read in file so for loop gets access to the file
						read(file, buffer, chunk);
						
				}		
				
				void *xor(void *ptr)  // xor each thread
				{
						for (j = 0; j < chunk; j++)  // go through each chunk
						{
								// xor each byte of the chunk with checksum
								// chunk is 5, j is num 1 - 5, meaning the bytes that make up each chunk
								checksum ^= buffer[j];  // j is what byte i am on; buffer[] contains content of file
								// checksum number stays saved in checksum so it works to loop
						}
						pthread_exit(0);
						// get checksum number of each chunk
				}
				pthread_create(&tid, NULL, &xor, (void *)&i);
				pthread_join(tid, NULL);  // join each xor of each thread and now this goes back up top
			}
			
			end_t = clock();  // end of clock
			total_t = (end_t - start_t);  // total time it took for all processes to be run
			
	printf("Total clock time: %ld\n", total_t);
	printf("Checksum is: %d\n", checksum);
	return 0;
}
