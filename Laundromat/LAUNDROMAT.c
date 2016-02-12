// LAURA URIBE
// OS, HWK 3
// SEGEV

#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <semaphore.h>

#define K_STATIONS 5
#define N_MACHINES 20

// initialize mutex
pthread_mutex_t mutex = PTHREAD_MUTEX_INITIALIZER; 

//create semaphore
sem_t sem_nfree;

int available[N_MACHINES] = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};

void *runStation(void *ptr);
void *runMachine(void *ptr);

void setup(int stations, int machines)
{

	pthread_t kstation_thread[K_STATIONS];
	sem_init(&sem_nfree, 0, N_MACHINES);

	int j;
	int k;
	
	// created threads for each K_STATIONS
	for(k = 0; k < K_STATIONS; k++)
	{
		pthread_create(&kstation_thread[k], NULL, &runStation, (void *)&k);
		printf("SETUP: Creating K_STATIONS thread %d\n", k);
	}
	
	pthread_t nmachine_thread[N_MACHINES];
	
	for (j = 0; j < N_MACHINES; j++)
	{
		pthread_create(&nmachine_thread[j], NULL, &runMachine, (void *)&j);
		printf("SETUP: Creating N_MACHINES thread %d\n", j);
	}
	
	// counting semaphore
	// mutex for allocate
	// mutex for each machine
	
	//int N_FREE = N_MACHINES;
	
	// define & initialize n_free semaphore to number of machines
	//sem_t sem_nfree = N_MACHINES;
	// define semaphores
	// sem_t sem_nmachines;
	// sem_t sem_allocate; 
	
	// makes sure it doesn't allocate to the same machine
	sem_wait(&sem_nfree); 
	// my critical section code
	// non-shared resource
	sem_post(&sem_nfree);

}

void *runMachine(void *ptr)  // simulate that the machine is running
// wait for it to be signaled in allocate
{
	// do actual threading here for N_MACHINES
		
	// boolean - is machine being used?
	while(1)  // this is correct
	{
		// mutex locks/unlocks machine and sleeps for 5 seconds
		pthread_mutex_lock(&mutex);  // wait
		sleep(5);
		pthread_mutex_unlock(&mutex);  // release
		 
	}
}

int allocate()   // choose which machine to use
{
	int i;
	sem_wait(&sem_nfree);
	pthread_mutex_lock(&mutex);
	
	// this is where you do the "allocating"
	for(i = 0; i < N_MACHINES; i++)
	{
		if (available[i] != 0)  // available array
		{
			available[i] = 0;
			pthread_mutex_lock(&mutex);
			return i;
		}
	}
	return 0;
	//post(&mutex);
	//post(&station_mutex);
	
	//---------------
	/*// mutex allocates to the machine only once
	pthread_mutex_lock(&m_allocate);
	sleep(5);
	pthread_mutex_unlock(&m_allocate); 
	
	// mutex 
	pthread_mutex_lock(&m_machines);
	sleep(5);
	pthread_mutex_unlock(&m_machines);
	
	sem_init(&lock, 0, 1); // binary semaphore lock = 1;  
	sem_wait(N_FREE);
	producer(lock);
	
	*/
	
	// sem_post signal array index of this thread mutex to start runMachine
}

void release(int machine)  // this is correct
{
	// sets the machine with the given id as available to be allocated again.	
	pthread_mutex_lock(&mutex);
	available[machine] = 1;
	pthread_mutex_unlock(&mutex);
	sem_post(&sem_nfree);
}

void *runStation(void *ptr)
{
	
}

int main(int argc, char **argv)
{
	
	return 0;
}


