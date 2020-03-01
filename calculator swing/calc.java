
import java.awt.event.*;  
import java.util.Stack;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

class Calc {

    static String s="";   
public static void main(String[] args) {  
    
JTextField tf=new JTextField("  ",140);
tf.setBounds(30,30,250,50);   
JFrame f=new JFrame("Button Example"); 
f.setTitle("Calculator");
JButton add=new JButton("+");
add.setBounds(200,100,80,40);

JButton sub=new JButton("-");
sub.setBounds(200,200,80,40);

JButton mul=new JButton("x");
mul.setBounds(200,300,80,40);

JButton div=new JButton("/");
div.setBounds(200,400,80,40);

JButton cls=new JButton("clear ");
cls.setBounds(50,480,100,40);

JButton eq=new JButton("=");
eq.setBounds(140,400,60,40);

JButton bak=new JButton("Backspace");
bak.setBounds(170,480,100,40);

JButton zero=new JButton("0");
zero.setBounds(90,400,60,40);

JButton dot=new JButton(".");
dot.setBounds(30,400,60,40);

JButton one=new JButton("1");
one.setBounds(30,100,60,40);

JButton two=new JButton("2");
two.setBounds(90,100,60,40);

JButton three=new JButton("3");
three.setBounds(140,100,60,40);

JButton four=new JButton("4");
four.setBounds(30,200,60,40);

JButton fiv=new JButton("5");
fiv.setBounds(90,200,60,40);

JButton six=new JButton("6");
six.setBounds(140,200,60,40);

JButton sev=new JButton("7");
sev.setBounds(30,300,60,40);

JButton eig=new JButton("8");
eig.setBounds(90,300,60,40);

JButton nine=new JButton("9");
nine.setBounds(140,300,60,40);




//event perform
    one.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e){  
            tf.setText(s+"1"); 
            s=s+"1"; 
        }   });  
    two.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e){  
            tf.setText(s+"2");  
            s=s+"2";
        }   });  
    three.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e){  
            tf.setText(s+"3");
            s=s+"3";  
        }   });  
    four.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e){  
            tf.setText(s+"4");  
            s=s+"4";
        }   });  
    fiv.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e){  
            tf.setText(s+"5");  
            s=s+"5"; 
       }   });  
    six.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e){  
            tf.setText(s+"6");
            s=s+"6";  
        }   });  
    sev.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e){  
            tf.setText(s+"7");  
            s=s+"7";
        }   });  
    eig.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e){  
            tf.setText(s+"8");  
            s=s+"8";
        }   });  
    nine.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e){  
            tf.setText(s+"9");  
            s=s+"9";
        }   });  
    zero.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e){  
            tf.setText(s+"0"); 
            s=s+"0"; 
        }   });  
    add.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e){  
            tf.setText(s+"+");  
            s=s+" + ";  
      }   });  
    sub.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e){  
            tf.setText(s+"-");  
            s=s+" - ";    
    }   });  
    div.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e){  
            tf.setText(s+"/");  
            s=s+" / ";  
      }   });  
    mul.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e){  
            tf.setText(s+"*");  
            s=s+" * ";  
      }   });  
    eq.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e){  
           tf.setText(" = "); 
           float result = EvaluateString(s);
           tf.setText(Float.toString(result));
        } });
    cls.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        s=" ";
    tf.setText(s);
    
    }});
    dot.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){
            tf.setText(s+".");
            s=s+".";
      }   });
    bak.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){
           String s=tf.getText();
			tf.setText("");
			for(int i=0;i<s.length()-1;i++)
			tf.setText(tf.getText()+s.charAt(i));
      }   });
    
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
f.add(bak);
    
    f.setSize(400,600);  
    f.setLayout(null);  
    f.setVisible(true);
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
		return 0;  } }
