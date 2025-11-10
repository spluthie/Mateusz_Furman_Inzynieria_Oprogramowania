package edu.io.player;
import edu.io.player.Tool;
import java.util.Stack;

public class Shed {

    private Stack<Tool> tools = new Stack<>();

    public Shed(){

    }


    public boolean isEmpty(){
        return tools.isEmpty();
    }


    public void add(Tool tool){
        if (tool == null){
            throw new IllegalArgumentException();
        }
            tools.push(tool);
    }


    public Tool getTool(){
        if(tools.isEmpty()){
            return new NoTool();
        }
        else{
            return tools.peek();
        }
    }


    public void dropTool(){
        if(!tools.isEmpty()) tools.pop();
    }

}
