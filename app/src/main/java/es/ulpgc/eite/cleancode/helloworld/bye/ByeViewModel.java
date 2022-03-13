package es.ulpgc.eite.cleancode.helloworld.bye;

import java.util.Objects;

import es.ulpgc.eite.cleancode.helloworld.hello.HelloViewModel;

public class ByeViewModel {

    public String byeMessage = "?";

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        HelloViewModel viewModel = (HelloViewModel) obj;
        return Objects.equals(byeMessage, viewModel.helloMessage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(byeMessage);
    }

    @Override
    public String toString() {
        return
                "helloMessage: " + byeMessage;
    }

}
