package codelab07;

import codelab07.domain.ConnectFourService;

public class ConnectFourApp {
    public static void main(String[] args) {
        ConnectFourService service = new ConnectFourService();
        service.displayGrid();
    }
}
