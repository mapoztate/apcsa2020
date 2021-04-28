import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

/**
 * CelebrityPanel for the game Celebrity
 * 
 * @author cody.henrichsen
 * @version 2.9 18/09/2018 Adjusted the listener functionality.
 */
public class CelebrityPanel extends JPanel
{
  
  /**
   * The button pressed when making a guess.
   */
  private JButton guessButton;
  
  /**
   * The button pressed to restart the game
   */
  private JButton resetButton;
  
  /**
   * The label used to identify what to type in the field
   */
  private JLabel guessLabel;
  
  /**
   * The label to hold the static text for the timer
   */
  private JLabel staticTimerLabel;
  
  /**
   * The label to hold the dynamic text of the timer.
   */
  private JLabel dynamicTimerLabel;
  
  /**
   * Timer for display
   */
  private Timer countdownTimer;
  
  /**
   * Listener for the countdownTimer
   */
  private ActionListener timerListener;
  
  /**
   * Holds the user and program input text area and allows the text to scroll.
   */
  private JScrollPane cluePane;
  
  /**
   * The text area for user and program information
   */
  private JTextArea clueArea;
  
  /**
   * The user interaction field.
   */
  private JTextField guessField;
  
  /**
   * Layout manager for the panel. Uses constraints between components to
   * align or spring from edges.
   */
  private SpringLayout panelLayout;
  
  /**
   * The String used when a user correctly guesses the Celebrity
   */
  private String success;
  
  /**
   * The String used when a user has not guessed correctly.
   */
  private String tryAgain;
  
  /**
   * The current value of the time in seconds.
   */
  private int seconds;
  
  /**
   * Reference to the game instance.
   */
  private CelebrityGame controller;
  
  /**
   * Builds the CelebrityPanel and initializes all data members.
   * 
   * @param controller
   *            Reference to the Game passed when the CelebrityPanel is
   *            instantiated in the Frame.
   */
  public CelebrityPanel(CelebrityGame controller)
  {
    super();
    this.controller = controller;
    this.panelLayout = new SpringLayout();
    this.guessLabel = new JLabel("Guess:");
    this.staticTimerLabel = new JLabel("Time remaining: ");
    this.dynamicTimerLabel = new JLabel("60");
    this.guessButton = new JButton("Submit guess");
    this.resetButton = new JButton("Start again");
    this.clueArea = new JTextArea("", 30, 20);
    this.cluePane = new JScrollPane(clueArea);
    this.guessField = new JTextField("Enter guess here", 30);
    this.success = "You guessed correctly!!! \nNext Celebrity clue is: ";
    this.tryAgain = "You have chosen poorly, try again!\nThe clue is: ";
    this.seconds = 60;
    this.countdownTimer = new Timer(1000, timerListener);
    
    setupPanel();
    setupLayout();
    setupListeners();
    
    
  }
  
  /**
   * Helper method to add all components to the panel and adjust GUI settings
   * including scroll bars, and line wrap.
   */
  private void setupPanel()
  {
    this.setLayout(panelLayout);
    this.add(guessLabel);
    this.add(cluePane);
    this.add(guessField);
    this.add(guessButton);
    this.add(resetButton);
    this.add(dynamicTimerLabel);
    this.add(staticTimerLabel);
    
    //Changes the font to be larger than default
    staticTimerLabel.setFont(new Font("Helvetica", Font.BOLD,20));
    dynamicTimerLabel.setFont(new Font("Helvetica", Font.BOLD,20));
    
    // These lines allow vertical scrolling but not horizontal.
    cluePane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    cluePane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    
    // These lines allow word and line wrapping for the clue area.
    clueArea.setWrapStyleWord(true);
    clueArea.setLineWrap(true);
    
    // The clue area is set to not be editable by the user :D
    clueArea.setEditable(false);
    
  }
  
  /**
   * Using a helper method to hold all the constraints for the GUI components
   * in the panel
   */
  private void setupLayout()
  {
    panelLayout.putConstraint(SpringLayout.NORTH, cluePane, 15, SpringLayout.NORTH, this);
    panelLayout.putConstraint(SpringLayout.WEST, cluePane, 15, SpringLayout.WEST, this);
    panelLayout.putConstraint(SpringLayout.SOUTH, cluePane, -100, SpringLayout.SOUTH, this);
    panelLayout.putConstraint(SpringLayout.EAST, cluePane, -15, SpringLayout.EAST, this);
    panelLayout.putConstraint(SpringLayout.NORTH, guessButton, 10, SpringLayout.SOUTH, guessLabel);
    panelLayout.putConstraint(SpringLayout.SOUTH, guessButton, -15, SpringLayout.SOUTH, this);
    panelLayout.putConstraint(SpringLayout.NORTH, resetButton, 0, SpringLayout.NORTH, guessButton);
    panelLayout.putConstraint(SpringLayout.EAST, guessButton, 0, SpringLayout.EAST, cluePane);
    panelLayout.putConstraint(SpringLayout.WEST, resetButton, 0, SpringLayout.WEST, cluePane);
    panelLayout.putConstraint(SpringLayout.NORTH, guessLabel, 10, SpringLayout.SOUTH, cluePane);
    panelLayout.putConstraint(SpringLayout.WEST, guessLabel, 0, SpringLayout.WEST, cluePane);
    panelLayout.putConstraint(SpringLayout.SOUTH, resetButton, 0, SpringLayout.SOUTH, guessButton);
    panelLayout.putConstraint(SpringLayout.NORTH, guessField, 0, SpringLayout.NORTH, guessLabel);
    panelLayout.putConstraint(SpringLayout.WEST, guessField, 5, SpringLayout.EAST, guessLabel);
    panelLayout.putConstraint(SpringLayout.EAST, guessField, 0, SpringLayout.EAST, cluePane);
    panelLayout.putConstraint(SpringLayout.NORTH, staticTimerLabel, 15, SpringLayout.NORTH, resetButton);
    panelLayout.putConstraint(SpringLayout.WEST, staticTimerLabel, 10, SpringLayout.EAST, resetButton);
    panelLayout.putConstraint(SpringLayout.NORTH, dynamicTimerLabel, 0, SpringLayout.NORTH, staticTimerLabel);
    panelLayout.putConstraint(SpringLayout.WEST, dynamicTimerLabel, 5, SpringLayout.EAST, staticTimerLabel);
    
  }
  
  /*
   * Attaches listeners to the GUI components of the program
   */
  private void setupListeners()
  {
    
    /**
     * Attaches a listener to the resetButton and uses it to call the reset
     * method in the game.
     */
    resetButton.addActionListener(new ActionListener()
                                    {
      public void actionPerformed(ActionEvent mouseClick)
      {
    	if(controller.getCelebrityGameSize() == 0)
    		controller.closeGame();
        controller.play();
      }
    });
    
    /**
     * Attaches a listener to the guessButton and uses it to call the
     * updateScreen method in the panel.
     */
    guessButton.addActionListener(new ActionListener()
                                    {
      public void actionPerformed(ActionEvent mouseClick)
      {
        updateScreen();
      }
    });
    
    /**
     * Attaches a listener to the guessField for enter key press and uses it
     * to call the updateScreen method in the panel.
     */
    guessField.addActionListener(new ActionListener()
                                   {
      public void actionPerformed(ActionEvent enterPress)
      {
        updateScreen();
      }
    });
    
    countdownTimer.addActionListener(new ActionListener()
                                       {
      public void actionPerformed(ActionEvent timerFire)
      {
        timerFires();
      }
    });
    
    countdownTimer.start();
  }
  
  /**
   * Helper method for when the ActionListener attached to the timer fires.
   * Sets the text of the label to match the remaining time and a message at
   * the end.
   */
  private void timerFires()
  {
    seconds--;
    
    if (seconds <= 10)
    {
      dynamicTimerLabel.setFont(new Font("Helvetica", Font.BOLD,20));
      dynamicTimerLabel.setForeground(Color.RED);
    }
    
    if (seconds < 0)
    {
      staticTimerLabel.setText("Times up!");
      dynamicTimerLabel.setText("00");
      seconds = 60;
      countdownTimer.stop();
      guessButton.setEnabled(false);
      guessField.setEnabled(false);
    }
    else
    {
      dynamicTimerLabel.setText("" + seconds);
    }
    
  }
  
  /**
   * Method to add a clue to the screen from the game instance
   * 
   * @param clue
   *            The clue to add to the screen.
   */
  public void addClue(String clue)
  {
    clueArea.setText("The clue is: " + clue);
    seconds = 60;
    dynamicTimerLabel.setForeground(Color.BLACK);
    countdownTimer.restart();
    staticTimerLabel.setText("Time remaining: ");
    guessButton.setEnabled(true);
    guessField.setEnabled(true);
  }
  
  /**
   * Refactored method to allow both button and enter press in the guessField
   * to provide the same functionality.
   */
  private void updateScreen()
  {
    String currentGuess = guessField.getText();
    clueArea.append("\nYou guessed: " + currentGuess + "\n");
    
    if (controller.processGuess(currentGuess))
    {
      clueArea.append(success + controller.sendClue());
      clueArea.setBackground(Color.CYAN);
    }
    else
    {
      clueArea.setBackground(Color.WHITE);
      clueArea.append(tryAgain);
      clueArea.append(controller.sendClue());
    }
    
    if (controller.getCelebrityGameSize() == 0)
    {
      clueArea.append("\nNo more celebrities to guess.");
      guessButton.setEnabled(false);
      guessField.setEnabled(false);
    }
    // Used to move the text area to the current cursor
    clueArea.setCaretPosition(clueArea.getDocument().getLength());
    
  }
  
}
