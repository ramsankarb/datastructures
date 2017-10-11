/**
 * Created by Ramshankar on 10/11/17.
 */
//Enter your code here. Read input from STDIN. Print output to STDOUT
def reader = new BufferedReader(new InputStreamReader(System.in))
def (n, k) = reader.readLine().split(' ').collect { it as int }
def array = reader.readLine().split(' ').collect { it as int }.toList()
def currentNum = k
n.times{
    print(array[currentNum]+" ")
    currentNum++
    if(currentNum>=n){
        currentNum=0
    }
}