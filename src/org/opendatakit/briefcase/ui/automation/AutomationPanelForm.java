package org.opendatakit.briefcase.ui.automation;

import static org.opendatakit.briefcase.ui.reused.FileChooser.directory;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.function.Consumer;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.opendatakit.briefcase.automation.AutomationConfiguration;
import org.opendatakit.briefcase.export.ExportConfiguration;
import org.opendatakit.briefcase.model.BriefcasePreferences;
import org.opendatakit.briefcase.ui.export.components.ConfigurationDialog;
import org.opendatakit.briefcase.util.StringUtils;

@SuppressWarnings("checkstyle:MethodName")
public class AutomationPanelForm {
  public JPanel container;
  private JLabel scriptDirLabel;
  private JTextField scriptDirField;
  private JButton scriptDirChooseButton;
  private JButton generateScriptButton;
  private JButton changeDefaultConfigurationButton;

  private AutomationConfiguration configuration = AutomationConfiguration.empty();

  public AutomationPanelForm() {
    $$$setupUI$$$();
    scriptDirChooseButton.addActionListener(__ ->
        directory(container, fileFrom(scriptDirField))
            .choose()
            .ifPresent(file -> setScriptDir(Paths.get(file.toURI()))));
    changeDefaultConfigurationButton.addActionListener(__ -> setExportConfiguration());
    if (configuration.getExportConfiguration().isPresent()) {
      changeDefaultConfigurationButton.setText("Change export configuration");
    }
  }

  private void setExportConfiguration() {
    Optional<ExportConfiguration> defaultConfiguration = configuration.getExportConfiguration();
    ConfigurationDialog dialog = ConfigurationDialog.from(defaultConfiguration, true, BriefcasePreferences.getStorePasswordsConsentProperty());
    dialog.onOK(config -> {
      configuration.setExportConfiguration(config);
    });
    dialog.open();
    if (configuration.getExportConfiguration().isPresent()) {
      changeDefaultConfigurationButton.setText("Change export configuration");
    }
  }

  void onGenerate(Consumer<AutomationConfiguration> callback) {
    generateScriptButton.addActionListener(__ -> callback.accept(configuration));
  }

  private void setScriptDir(Path path) {
    scriptDirField.setText(path.toString());
    configuration.setScriptLocation(Paths.get(scriptDirField.getText()));
  }

  private static Optional<File> fileFrom(JTextField textField) {
    return Optional.ofNullable(textField.getText())
        .filter(StringUtils::nullOrEmpty)
        .map(path -> Paths.get(path).toFile());
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
    scriptDirLabel = new JLabel();
    scriptDirLabel.setText("Script Location");
    GridBagConstraints gbc;
    gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.gridy = 1;
    gbc.anchor = GridBagConstraints.WEST;
    container.add(scriptDirLabel, gbc);
    final JPanel spacer1 = new JPanel();
    gbc = new GridBagConstraints();
    gbc.gridx = 1;
    gbc.gridy = 1;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    container.add(spacer1, gbc);
    scriptDirField = new JTextField();
    scriptDirField.setEditable(false);
    gbc = new GridBagConstraints();
    gbc.gridx = 2;
    gbc.gridy = 1;
    gbc.weightx = 1.0;
    gbc.anchor = GridBagConstraints.WEST;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    container.add(scriptDirField, gbc);
    scriptDirChooseButton = new JButton();
    scriptDirChooseButton.setText("Choose...");
    gbc = new GridBagConstraints();
    gbc.gridx = 3;
    gbc.gridy = 1;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    container.add(scriptDirChooseButton, gbc);
    generateScriptButton = new JButton();
    generateScriptButton.setText("Generate Script");
    gbc = new GridBagConstraints();
    gbc.gridx = 2;
    gbc.gridy = 5;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    container.add(generateScriptButton, gbc);
    final JPanel spacer2 = new JPanel();
    gbc = new GridBagConstraints();
    gbc.gridx = 2;
    gbc.gridy = 6;
    gbc.weighty = 1.0;
    gbc.fill = GridBagConstraints.VERTICAL;
    container.add(spacer2, gbc);
    final JPanel spacer3 = new JPanel();
    gbc = new GridBagConstraints();
    gbc.gridx = 2;
    gbc.gridy = 0;
    gbc.fill = GridBagConstraints.VERTICAL;
    container.add(spacer3, gbc);
    changeDefaultConfigurationButton = new JButton();
    changeDefaultConfigurationButton.setText("Set export configuration");
    gbc = new GridBagConstraints();
    gbc.gridx = 2;
    gbc.gridy = 3;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    container.add(changeDefaultConfigurationButton, gbc);
    final JPanel spacer4 = new JPanel();
    gbc = new GridBagConstraints();
    gbc.gridx = 2;
    gbc.gridy = 4;
    gbc.fill = GridBagConstraints.VERTICAL;
    container.add(spacer4, gbc);
    final JPanel spacer5 = new JPanel();
    gbc = new GridBagConstraints();
    gbc.gridx = 2;
    gbc.gridy = 2;
    gbc.fill = GridBagConstraints.VERTICAL;
    container.add(spacer5, gbc);
  }

  /**
   * @noinspection ALL
   */
  public JComponent $$$getRootComponent$$$() {
    return container;
  }
}
