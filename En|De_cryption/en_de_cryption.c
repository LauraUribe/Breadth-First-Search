/* 

Laura URibe
OS_Hwk1
Prof._Yoav_Segev

(en/de)cryption_file_source_code_with_system_calls
*/

#include <unistd.h>

/* in order to use fstat */
#include <sys/stat.h>
#include <sys/types.h>
#include <fcntl.h>

#include <stdio.h>   // for file handling
#include <stdlib.h>  // for the exit function

// initialize the array of 4096 bytes
char inputBuffer[4096];
char keyBuffer[4096];

// main declaration accepts command line arguments
// argc is the number of arguments passed into program from command line
// argv[] lets user put in the file
int main (int argc, char *argv[])
{
	
	/* create unique ID for file placed by command line in structure
	int open (const char *path, int flags [, mode_t mode ]);
	*/
	//flag O_RDONLY opens file so that it is read only 
	// mode not put in the below statement bc no permissions are needed
	
	// create unique ID for input file
	int input_file = open(argv[1], O_RDONLY);
	// create unique ID for key file
	int key_file = open(argv[2], O_RDONLY);
	// create unique ID for output file 
	// write only mode or create output file if not there
	int output_file = open(argv[3], O_WRONLY | O_CREAT);
	
	
	// use fstat to figure out file size of specific file since it returns info on file
	// use argv[n] so it can determine which file to look at
	/*
	struct stat *buf is a structure where data about the file will
	be stored
	*/
	
	// create static structure
	// input file size
	struct stat fileStat_input;
	fstat(input_file, &fileStat_input);
	int input_size = fileStat_input.st_size;
	printf("Input File Size: \t\t%d bytes \n", input_size);
	
	// key file size
	struct stat fileStat_key;
	fstat(key_file, &fileStat_key);
	int key_size = fileStat_key.st_size;
	printf("Key File Size: \t\t%d bytes \n", key_size);

														
 	// key file position - current location
	int keyPosition = 0;
	// input file position - current location
	int inputPosition;
	
	
	int read_inputFile = 0;
	int read_keyFile = 0;
	int keyTotal = read_inputFile;
	
	// after all is read....
	// data position is i
	while (1)  // while true
	{
	// read input and key file in chunks
	// include 4KB buffer, which is 4096 bytes
	read_inputFile = read(input_file, inputBuffer, 4096);
	read_keyFile = read(key_file, keyBuffer, 4096);
	keyTotal = keyTotal + read_keyFile;

		for (inputPosition = 0; inputPosition < 4096; ++inputPosition);
		{
			
			// (en|de)crypt each chunk
			// ^ means xor
			inputBuffer[inputPosition]^=keyBuffer[keyPosition++];
			
			if (keyPosition == 4096)  // if key position is at the end of the file
			{
			keyPosition = 0;  // reset the key position to 0
			}
		
	else if (keyPosition == key_size || keyPosition == keyTotal)
		{
			close(key_file);
			key_file = open(argv[2], O_RDONLY);  // open file
			keyTotal = keyPosition + read_keyFile;
			keyPosition = 0;
		}
		}
			// do edge cases - what if key is larger than 4KB but less than file size
	
	// write the (en|de)crypted data
			write(output_file, inputBuffer, read_inputFile);
	
			// if end of file has been read in the allotted 4096KB....
			if (read_inputFile < 4096)
				break;
				
			else if (read_keyFile == key_size)
			{
				// read the keyFile again
				// cannot rewind -- close youtube and reopen to get to beginning of file
				close(key_file);  // close file
				key_file = open(argv[2], O_RDONLY);  // open file
				keyTotal = keyTotal + read_keyFile;
				keyPosition = 0;
			}
	}
	// close the indicated files
	close(input_file);
	close(key_file);
	close(output_file);
	
	return 0;
}

