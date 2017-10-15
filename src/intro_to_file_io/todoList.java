package intro_to_file_io;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class todoList implements MouseListener  {
	ArrayList<String> tasks=new ArrayList<String>();
	ArrayList<JLabel> labels=new ArrayList<JLabel>();
	JFrame f=new JFrame();
	JPanel p =new JPanel();
	JButton add=new JButton();
	JButton remove=new JButton();
	JButton save=new JButton();
	JButton load=new JButton();
	JLabel l;
	public todoList(){
		f.add(p);
		f.setVisible(true);
		p.add(add);
		add.addMouseListener(this);
		add.setText("add task");
		p.add(remove);
		remove.addMouseListener(this);
		remove.setText("remove task");
		p.add(save);
		save.addMouseListener(this);
		save.setText("save task");
		p.add(load);
		load.addMouseListener(this);
		load.setText("load task");
		f.setSize(200, 200);
		
	}
	public static void main(String[] args) {
		todoList x=new todoList();
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		for(int b=0;b<labels.size();b++) {
			p.remove(labels.get(b));
			
		}
		for(int x=1;x<tasks.size()+1;x++) {
			l = new JLabel();
			labels.add(l);
			l.setText(x+":"+tasks.get(x-1));
			p.add(l);
			f.validate();
		}
		if(e.getSource()==add) {
			String task=JOptionPane.showInputDialog("Add task to list>>");
			tasks.add(task);
		}
		if(e.getSource()==remove) {
			String t=JOptionPane.showInputDialog("what number do you want to get rid of?");
			int u=Integer.parseInt(t);
			p.remove(labels.get(u-1));
			tasks.remove(u-1);
		}
		if(e.getSource()==save) {

			try {
				FileWriter fw1 = new FileWriter("src/intro_to_file_io/tasks");
				BufferedWriter bw=new BufferedWriter(fw1);
				for(int y=0;y<tasks.size();y++) {
					bw.write(tasks.get(y)+"\n");
				}
				bw.close();
				fw1.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			
		}
		if(e.getSource()==load) {
			FileReader fr;
			try {
				fr = new FileReader("src/intro_to_file_io/tasks");
				BufferedReader br=new BufferedReader(fr);
				tasks.removeAll(tasks);

				String line = br.readLine();
				while(line != null){
					tasks.add(line);
					line = br.readLine();
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		for(int b=0;b<labels.size();b++) {
			p.remove(labels.get(b));
			
		}
		for(int x=1;x<tasks.size()+1;x++) {
			l = new JLabel();
			labels.add(l);
			l.setText(x+":"+tasks.get(x-1));
			p.add(l);
			f.validate();
		}
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
