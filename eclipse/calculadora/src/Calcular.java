import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.TouchListener;
import org.eclipse.swt.events.TouchEvent;

public class Calcular {
	private static Text text;
	public static float aNum;
	public static float bNum;
	public static float resultNum;
	public static boolean primer = true;
	//public static String acum= text.getText();
	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Display display = Display.getDefault();
		Shell shell = new Shell();
		shell.setSize(250, 300);
		shell.setText("SWT Application");
		
		
		text = new Text(shell, SWT.BORDER);
		text.setText("");
		text.setBounds(36, 10, 190, 30);

		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) 
			{
				
				text.setText(text.getText()+"0");
			}
		});
		btnNewButton.setBounds(36, 213, 40, 40);
		btnNewButton.setText("0");

		Button btnNewButton_1 = new Button(shell, SWT.NONE);
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) 
			{
				
				text.setText(text.getText()+"1");
			}
		});	
		btnNewButton_1.setBounds(36, 158, 40, 40);
		btnNewButton_1.setText("1");

		Button btnNewButton_2 = new Button(shell, SWT.NONE);
		btnNewButton_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) 
			{
				 
				text.setText(text.getText()+"2");
			}
		});
		btnNewButton_2.setBounds(89, 158, 40, 40);
		btnNewButton_2.setText("2");

		Button btnNewButton_3 = new Button(shell, SWT.NONE);
		btnNewButton_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) 
			{
				 
				text.setText(text.getText()+"3");
			}
		});
		btnNewButton_3.setBounds(142, 158, 40, 40);
		btnNewButton_3.setText("3");

		Button btnNewButton_4 = new Button(shell, SWT.NONE);
		btnNewButton_4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) 
			{
				 
				text.setText(text.getText()+"4");
			}
		});
		btnNewButton_4.setBounds(36, 107, 40, 40);
		btnNewButton_4.setText("4");

		Button btnNewButton_5 = new Button(shell, SWT.NONE);
		btnNewButton_5.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) 
			{
				 
				text.setText(text.getText()+"5");
			}
		});
		btnNewButton_5.setBounds(89, 107, 40, 40);
		btnNewButton_5.setText("5");

		Button btnNewButton_6 = new Button(shell, SWT.NONE);
		btnNewButton_6.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) 
			{
				 
				text.setText(text.getText()+"6");
			}
		});
		btnNewButton_6.setBounds(142, 107, 40, 40);
		btnNewButton_6.setText("6");

		Button btnNewButton_7 = new Button(shell, SWT.NONE);
		btnNewButton_7.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) 
			{
				 
				text.setText(text.getText()+"7");
			}
		});
		btnNewButton_7.setBounds(36, 55, 40, 40);
		btnNewButton_7.setText("7");

		Button btnNewButton_8 = new Button(shell, SWT.NONE);
		btnNewButton_8.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) 
			{
				 
				text.setText(text.getText()+"8");
			}
		});
		btnNewButton_8.setBounds(89, 55, 40, 40);
		btnNewButton_8.setText("8");

		Button btnNewButton_9 = new Button(shell, SWT.NONE);
		btnNewButton_9.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) 
			{
				 
				text.setText(text.getText()+"9");
			}
		});
		btnNewButton_9.setBounds(142, 55, 40, 40);
		btnNewButton_9.setText("9");

		Button btnNewButton_10 = new Button(shell, SWT.NONE);
		btnNewButton_10.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) 
			{
				String bst="";
				String caracter="";
				String caracter1="";
				char [] cadResult= text.getText().toCharArray();
				System.out.println(cadResult.length);
				System.out.println(cadResult[2]);
				for (int i = 0; i < cadResult.length; i++) 
				{
					caracter=Character.toString(cadResult[i]);
					if((caracter == "+")||(caracter == "-")||(caracter == "*")||(caracter == "/")||(i==cadResult.length-1))
					{
						if((caracter == "+")||(caracter == "-")||(caracter == "*")||(caracter == "/"))
						{
						caracter1=caracter;
						}
						if (primer== true)
						{
							aNum = Float.parseFloat(bst);
							bst="0";
							primer=false;
						}
						if(i==cadResult.length-1)
						{
							caracter=caracter1;
						}
						operacio(aNum, bst, caracter);
						bst="";
						i++;
					}
					caracter=Character.toString(cadResult[i]);
						bst=bst+caracter;
					
				}
				
				text.setText(Float.toString(aNum));
				
			}
		});
		btnNewButton_10.setBounds(89, 214, 95, 39);
		btnNewButton_10.setText("=");

		Button button = new Button(shell, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) 
			{
				 
				text.setText(text.getText()+"/");
			}
		});
		button.setText("/");
		button.setBounds(191, 55, 40, 40);

		Button button_1 = new Button(shell, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) 
			{
				 
				text.setText(text.getText()+"*");
			}
		});
		button_1.setText("*");
		button_1.setBounds(191, 107, 40, 40);

		Button button_2 = new Button(shell, SWT.NONE);
		button_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) 
			{
				aNum = Integer.parseInt(text.getText());
				
				 
				text.setText(text.getText()+"+");
			}
		});
		button_2.setText("+");
		button_2.setBounds(191, 158, 40, 40);

		Button button_3 = new Button(shell, SWT.NONE);
		button_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) 
			{
				text.setText(text.getText()+"-");
			}
		});
		button_3.setText("-");
		button_3.setBounds(191, 213, 40, 40);

		

		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
	
	public static void operacio (float a,String b, String c)
	{
		float bNew = Float.parseFloat(b);
		if (c=="+")
		{
			a=a+ bNew;
		}
		if (c=="-")
		{
			a=a- bNew;
		}
		if (c=="*")
		{
			a=a* bNew;
		}
		if (c=="/")
		{
			a=a/ bNew;
		}
	}
	
	} 