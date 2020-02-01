
package calcdj;
import java.awt.*;
import java.util.Stack;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Button;
import java.awt.*;
public class calc{
static String s="";
static int a,b;

public static void main(String args[]){
 
Frame f=new Frame("Button Example"); 
Button add=new Button("additon");
add.setBounds(230,200,80,30);
Button sub=new Button("subtraction");
sub.setBounds(230,300,80,30);
Button mul=new Button("multipicaltion");
mul.setBounds(230,400,80,30);
Button div=new Button("division");
div.setBounds(230,500,80,30);
Button cls=new Button("clear ");
cls.setBounds(30,500,80,30);

Button eq=new Button("=");
eq.setBounds(140,500,80,30);
final TextField tf=new TextField("  ",140);
tf.setBounds(30,100,200,50);
Button one=new Button("1");
one.setBounds(30,200,60,30);
Button two=new Button("2");
two.setBounds(90,200,60,30);
Button three=new Button("3");
three.setBounds(140,200,60,30);
Button four=new Button("4");
four.setBounds(30,300,60,30);
Button fiv=new Button("5");
fiv.setBounds(90,300,60,30);
Button six=new Button("6");
six.setBounds(140,300,60,30);
Button sev=new Button("7");
sev.setBounds(30,400,60,30);
Button eig=new Button("8");
eig.setBounds(90,400,60,30);
Button nine=new Button("9");
nine.setBounds(140,400,60,30);
Button zero=new Button("0");
zero.setBounds(90,500,60,30);
Button dot=new Button(".");
dot.setBounds(110,500,60,30);
f.add(add);
f.add(sub);
f.add(mul);
f.add(div);
f.add(cls);
f.add(eq);
f.add(one);
f.add(two);
f.add(three);
f.add(four);
f.add(fiv);
f.add(six);
f.add(sev);
f.add(eig);
f.add(nine);
f.add(zero);
f.add(dot);
f.add(tf);
f.setSize(600,600);//frame size 300 width and 300 height
f.setLayout(null);//no layout now bydefault BorderLayout
f.setVisible(true);
add.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        s=s+"+";
    tf.setText(s);
    
    }});
sub.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        s=s+"-";
    tf.setText(s);
    
    }});
mul.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        s=s+"*";
    tf.setText(s);
    
    }});
div.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        s=s+"/";
    tf.setText(s);
    
    }});
cls.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        s=" ";
    tf.setText(s);
    
    }});
eq.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        tf.setText(" = "); 
           float result = EvaluateString(s);
           tf.setText(Float.toString(result));
    }});

one.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        s=s+"1";
    tf.setText(s);
        }});

   
two.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        s=s+"2";
    tf.setText(s);
    
    }});

 
three.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        s=s+"3";
    tf.setText(s);
    
    }});
four.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        s=s+"4";
    tf.setText(s);
    
    }});
fiv.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        s=s+"5";
    tf.setText(s);
    
    }});
six.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        s=s+"6";
    tf.setText(s);
    
    }});
sev.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        s=s+"7";
    tf.setText(s);
    
    }});
eig.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        s=s+"8";
    tf.setText(s);
    
    }});
nine.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        s=s+"9";
    tf.setText(s);
    
    }});
zero.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        s=s+"0";
    tf.setText(s);
    
    }});
dot.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        s=s+".";
    tf.setText(s);
    
    }});





}
    static float EvaluateString(String s1) 
	{
		char tokens[] = s1.toCharArray();

		Stack<Float> values = new Stack<Float>();
		Stack<Character> ops = new Stack<Character>();

		for(int i = 0; i< tokens.length; i++)
		{
			if(tokens[i] == ' ') 
			{
				continue;
			}
			if(tokens[i] >= '0' && tokens[i] <= '9' || tokens[i] == '.')
			{
				StringBuffer buff = new StringBuffer();
				while(i < tokens.length ) {
					if( tokens[i] >= '0' && tokens[i] <= '9' || tokens[i] == '.')
					{
						buff.append(tokens[i++]);
					}
					else 
					{
						break;
					}
				}
				values.push(Float.parseFloat(buff.toString()));
			}
			else if(tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/')
			{
				while(!ops.empty() && hasPrecedence(tokens[i], ops.peek())) {
					values.push(result(ops.pop(), values.pop(), values.pop()));
				}
				ops.push(tokens[i]);
			}
		}
		while(!ops.empty())
		{
			values.push(result(ops.pop(), values.pop(), values.pop()));
		}
		return values.pop();
	}

	static boolean hasPrecedence(char op1, char op2)
	{
		if((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) 
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	static float result(char op, float b, float a)
	{
		switch(op)
		{
			case '+':
				return a+b;
			case '-':
				return a-b;
			case '*':
				return a*b;
			case '/':
				if(b != 0)
				{
					return a/b;
				}
				else 
				{
					throw new UnsupportedOperationException("Cannot divide by zero");
				}
		}
		return 0;
	}		
} 