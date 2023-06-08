package SchemeConverter;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.TextArea;

@SuppressWarnings("serial")
public class GInterface extends JFrame {

	private JPanel contentPane;
	private JTextField txtFinaldelimnoneDelimQuotedouble;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GInterface frame = new GInterface();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GInterface() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 356, 436);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel();
		lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblNewLabel_2.setForeground(new Color(0, 128, 255));
		lblNewLabel_2.setBounds(20, 108, 314, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel();
		lblNewLabel_2_1.setForeground(new Color(0, 128, 255));
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblNewLabel_2_1.setBounds(20, 176, 314, 14);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 5));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setEnabled(false);
		lblNewLabel_3.setBounds(344, 83, 0, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel = new JLabel("Scheme Converter");
		lblNewLabel.setBounds(38, 11, 267, 34);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 28));
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Select .CSV");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				fc.setMultiSelectionEnabled(true);
				FileNameExtensionFilter filter = new FileNameExtensionFilter(".CSV", "csv");
				fc.setFileFilter(filter);
				fc.showOpenDialog(null);
				File[] files = fc.getSelectedFiles();
				String label3 = "";
				String label2 = "";
				for(int i=0;i<files.length;i++) {
					if(label3.isEmpty()) {
						label3 += files[i].getName();
						label2 += files[i].getAbsolutePath();
					}
					else {
						label3 += ","+files[i].getName();
						label2 += ","+files[i].getAbsolutePath();						
					}
				}
				lblNewLabel_3.setText(label3);
				lblNewLabel_2.setText(label2);
			}
		});
		btnNewButton.setBounds(195, 77, 139, 20);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1_1 = new JLabel("Select CSV File:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(10, 68, 139, 34);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Select Dest. Route:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_1.setBounds(10, 131, 159, 34);
		contentPane.add(lblNewLabel_1_1_1);
		
		JButton btnSelectRoute = new JButton("Select Route");
		btnSelectRoute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				if(!lblNewLabel_2_1.getText().isEmpty()) {
					chooser.setCurrentDirectory(new java.io.File(lblNewLabel_2_1.getText()));					
				}
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				chooser.setAcceptAllFileFilterUsed(false);
			    chooser.showOpenDialog(null);
			    lblNewLabel_2_1.setText(chooser.getSelectedFile().getAbsolutePath());
   
			}
		});
		btnSelectRoute.setBounds(195, 140, 139, 20);
		contentPane.add(btnSelectRoute);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Set Params:");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_1_1.setBounds(10, 197, 105, 34);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		txtFinaldelimnoneDelimQuotedouble = new JTextField();
		txtFinaldelimnoneDelimQuotedouble.setForeground(new Color(128, 128, 128));
		txtFinaldelimnoneDelimQuotedouble.setText("final_delim=none, delim=';', quote=double");
		txtFinaldelimnoneDelimQuotedouble.setColumns(10);
		txtFinaldelimnoneDelimQuotedouble.setBounds(125, 206, 209, 20);
		contentPane.add(txtFinaldelimnoneDelimQuotedouble);
		
		TextArea textArea = new TextArea();
		textArea.setForeground(new Color(128, 128, 128));
		textArea.setFont(new Font("Dialog", Font.ITALIC, 12));
		textArea.setText("Logs...");
		textArea.setEditable(false);
		textArea.setBounds(10, 288, 324, 100);
		contentPane.add(textArea);		
		
		
		JButton btnConvert = new JButton("Convert");
		btnConvert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String destinationPath = lblNewLabel_2_1.getText();
				String parameters = txtFinaldelimnoneDelimQuotedouble.getText();
		
				if(destinationPath != "") {
					String[] filesNames = lblNewLabel_3.getText().split(",");
					String[] filesPaths = lblNewLabel_2.getText().split(",");
					String logArea ="";
					
					for(int i=0;i<filesNames.length;i++) {
						String fileName = DataConverter.convertName(filesNames[i]);
						String originPath = filesPaths[i];
						CSVWritter.imprimirResultados(fileName, parameters, originPath, destinationPath);
						logArea+=fileName+" File Generated Correctly \n";
						lblNewLabel_2.setText("");				
					}
					textArea.setText(logArea);
				}
				else {
					textArea.setText("Some Fields Are Empty. Please Complete Them First...");
				}
			}
		});
		btnConvert.setBounds(125, 248, 98, 34);
		contentPane.add(btnConvert);
		
		JLabel lblNewLabel_1 = new JLabel("*Can Select Multiple Files");
		lblNewLabel_1.setForeground(new Color(128, 128, 128));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel_1.setBounds(195, 62, 139, 14);
		contentPane.add(lblNewLabel_1);
		
			
	}
}
