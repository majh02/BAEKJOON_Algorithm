#include <stdio.h>
#include <stdlib.h>
#include <conio.h>
#include <stdbool.h>

#define BACKSPACE 8
#define ESC 27
#define QUEUE_SIZE 4

typedef struct queue                                                
{
    char cQueue[QUEUE_SIZE];                                  
    int front;                                                      
    int rear;  
    int length;
}Queue;

void initQueue(Queue *q)
{
    q->front = 0;
    q->rear = 0;
    q->length = 0;
    for (int i = 0; i < QUEUE_SIZE; i++){
        q->cQueue[i] = '\0';
    }
}

 

bool isFull(Queue *q)
{
    if (q->front == (q->rear + 1) % QUEUE_SIZE)
        return true;

    else return false;
}

 

bool isEmpty(Queue *q)
{   
    if (q->rear == q->front)
        return true;

    else return false;

}

 
void enQueue(Queue *q, char data)
{
    if (isFull(q))
    {   
        q->rear = q->front;
        q->front = (q->front + 1) % QUEUE_SIZE;
        q->cQueue[q->rear] = data;
    }

    else
    {
        q->rear = (q->rear + 1) % QUEUE_SIZE;
        q->cQueue[q->rear] = data;
        q->length += 1;
    }
}

void deQueue(Queue *q)
{

    //char dlt;
    if (isEmpty(q))
    {
        printf("Queue is EMPTY\n");
        q->front = (q->front + 1) % QUEUE_SIZE;
        q->cQueue[q->front] = '\0';
    }

    else
    {     
        q->front = (q->front + 1) % QUEUE_SIZE;
        //dlt = q->cQueue[q->front];
        q->cQueue[q->front] = '\0';
        q->length -= 1;
        //return dlt;
    }
}

 

void print(Queue *q)

{

       printf("==========================================\n");

       printf("       Circular Queue Test Program        \n");

       printf("==========================================\n");

 

       printf("Input   : Only Number & Alphabet\n");

       printf("Dequeue : BACKSPACE\n");

       printf("Exit    : ESC\n");

 

       printf("==========================================\n");

       printf("Front  : %d\n", q->front);

       printf("Rear   : %d\n", q->rear);

       printf("Length : %d\n", q->length);
       printf("Data   : %c\n",q->cQueue[q->rear]);

       //printf("Delete : %d\n", dlt);

 

       printf("==========================================\n");

}

 

int main(void) {
    Queue *q = malloc(sizeof(Queue));
    initQueue(q);
    char data;

    while(1)
    {
        data = getch();
        if ((int)data == 27) //ESC
        {
            free(q);
            exit(1);
        }

        else if ((int)data == 8)   //BACKSPACE
        {
            deQueue(q);
            print(q);
        }

        else
        {
            enQueue(q, data);
            print(q);
        }
    }
    
    return 0;
}