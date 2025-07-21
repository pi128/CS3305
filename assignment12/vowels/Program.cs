using System;

public class Program{
    public static void Main(string[] args){
    Console.Write("Enter a String do be vowled: ");
    string resp = Console.ReadLine();
    
    Console.WriteLine($"Number of vowels : {CountVowels(resp)}");
    }

    public static int CountVowels(String resp){
        
        if(string.IsNullOrEmpty(resp)){
            return 0;
        } 
        char first = char.ToLower(resp[0]);
        int count;
        if ("aeiou".Contains(first)){
            count = 1;
        } else {
            count = 0;
        }

        return count + CountVowels(resp.Substring(1));
    }
}