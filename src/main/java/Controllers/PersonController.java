package Controllers;

import GW.GW;
import Models.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import registries.GWRegistry;

public class PersonController {
    @FXML
    TableView<Person> personTableView;

    @FXML
    TableColumn<Person, String> personStringTableColumn;

    private GW<Person> personGW = GWRegistry.getInstance().getPersonGW();

    ObservableList<Person> personObservableList = FXCollections.observableArrayList(personGW.all());

    @FXML
    public void initialize(){
        personStringTableColumn.setCellValueFactory(cell->cell.getValue().nameProperty());
        personTableView.setItems(personObservableList);
    }

}
