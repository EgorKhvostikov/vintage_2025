package org.firstinspires.ftc.teamcode.RobotMoules.Observer;

public interface IObserver<T,K extends IListener<T>> {
    void register(K r);
    void remove(K r);
    void notifyListeners(T data);
}
