package org.opendatakit.briefcase.ui.reused;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("checkstyle:MethodName")
public class SourceDisplayPanelForm extends JComponent {
  private JPanel container;
  private JLabel sourceLabel;
  private JLabel sourceAddressLabel;
  private JButton resetButton;

  public SourceDisplayPanelForm(String source, String sourceAddress, Runnable runnable) {
    $$$setupUI$$$();
    sourceLabel.setText(source);
    sourceAddressLabel.setText(sourceAddress);

    resetButton.addActionListener(__ -> {
      runnable.run();
    });
  }

  private void createUIComponents() {
    // TODO: place custom component creation code here
  }

  /**
   * Method generated by IntelliJ IDEA GUI Designer
   * >>> IMPORTANT!! <<<
   * DO NOT edit this method OR call it in your code!
   *
   * @noinspection ALL
   */
  private void $$$setupUI$$$() {
    container = new JPanel();
    container.setLayout(new GridBagLayout());
    final JLabel label1 = new JLabel();
    label1.setText("Pulling data from ");
    GridBagConstraints gbc;
    gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.gridy = 0;
    container.add(label1, gbc);
    final JPanel spacer1 = new JPanel();
    gbc = new GridBagConstraints();
    gbc.gridx = 1;
    gbc.gridy = 0;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    container.add(spacer1, gbc);
    final JPanel spacer2 = new JPanel();
    gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.gridy = 1;
    gbc.fill = GridBagConstraints.VERTICAL;
    container.add(spacer2, gbc);
    sourceLabel = new JLabel();
    sourceLabel.setText("Source");
    gbc = new GridBagConstraints();
    gbc.gridx = 2;
    gbc.gridy = 0;
    gbc.weightx = 1.0;
    gbc.anchor = GridBagConstraints.WEST;
    container.add(sourceLabel, gbc);
    sourceAddressLabel = new JLabel();
    sourceAddressLabel.setText("Source Address");
    gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.gridy = 2;
    gbc.anchor = GridBagConstraints.WEST;
    container.add(sourceAddressLabel, gbc);
    resetButton = new JButton();
    resetButton.setText("Button");
    gbc = new GridBagConstraints();
    gbc.gridx = 2;
    gbc.gridy = 2;
    gbc.anchor = GridBagConstraints.EAST;
    container.add(resetButton, gbc);
  }

  /**
   * @noinspection ALL
   */
  public JComponent $$$getRootComponent$$$() {
    return container;
  }

  public JComponent getContainer() {
    return container;
  }
}
