import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class calculaotr extends Frame implements ActionListener {
static String s="";
calculaotr(){

Button a=new Button("additon");
a.setBounds(230,200,80,30);
Button b=new Button("subtraction");
b.setBounds(230,300,80,30);
Button c=new Button("multipicaltion");
c.setBounds(230,400,80,30);
Button d=new Button("division");
d.setBounds(230,500,80,30);
Button e=new Button("clear ");
e.setBounds(30,500,80,30);
Button f=new Button("==");
f.setBounds(140,500,80,30);
TextField tf=new TextField("  ",140);
tf.setBounds(30,100,200,50);
Button g=new Button("1");
g.setBounds(30,200,60,30);
Button h=new Button("2");
h.setBounds(90,200,60,30);
Button i=new Button("3");
i.setBounds(140,200,60,30);
Button j=new Button("4");
j.setBounds(30,300,60,30);
Button k=new Button("5");
k.setBounds(90,300,60,30);
Button l=new Button("6");
l.setBounds(140,300,60,30);
Button m=new Button("7");
m.setBounds(30,400,60,30);
Button n=new Button("8");
n.setBounds(90,400,60,30);
Button o=new Button("9");
o.setBounds(140,400,60,30);
Button p=new Button("00");
p.setBounds(90,500,60,30);
a.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        s=s+"+";
    tf.setText(s);
    
    }});
b.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        s=s+"-";
    tf.setText(s);
    
    }});
c.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        s=s+"*";
    tf.setText(s);
    
    }});
d.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        s=s+"/";
    tf.setText(s);
    
    }});
e.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        s=s+"";
    tf.setText(s);
    
    }});
f.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        tf.setText("= "); 
           int result = EvaluateString(s);
           tf.setText(Integer.toString(result));
    tf.setText(s);
    
    }

   
h.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        s=s+"2";
    tf.setText(s);
    
    }

 
i.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        s=s+"3";
    tf.setText(s);
    
    }});
j.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        s=s+"4";
    tf.setText(s);
    
    }});
k.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        s=s+"5";
    tf.setText(s);
    
    }});
l.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        s=s+"6";
    tf.setText(s);
    
    }});
m.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        s=s+"7";
    tf.setText(s);
    
    }});
n.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        s=s+"8";
    tf.setText(s);
    
    }});
o.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        s=s+"9";
    tf.setText(s);
    
    }});
p.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        s=s+"00";
    tf.setText(s);
    
    }});
p.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        s=s+"";
    tf.setText(s);
    
    }});



add(o);
add(tf);
add(a);
add(b);
add(c);
add(d);
add(e);
add(f);
add(g);
add(h);
add(i);
add(j);
add(k);
add(l);
add(m);
add(n);


setSize(600,600);//frame size 300 width and 300 height
setLayout(null);//no layout now bydefault BorderLayout
setVisible(true);//now frame willbe visible, bydefault not visible


}
public static void main(String args[]){

calculaotr f=new calculaotr();

}

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
 static int EvaluateString(String s1) 
	{
		char tokens[] = s1.toCharArray();

		Stack<Integer> values = new Stack<Integer>();
		Stack<Character> ops = new Stack<Character>();

		for(int i = 0; i< tokens.length; i++)
		{
			if(tokens[i] == ' ') 
			{
				continue;
			}
			if(tokens[i] >= '0' && tokens[i] <= '9')
			{
				StringBuffer buff = new StringBuffer();
				while(i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9') {
					buff.append(tokens[i++]);
				}
				values.push(Integer.parseInt(buff.toString()));
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

	static int result(char op, int b, int a)
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