package org.firstinspires.ftc.teamcode.Sonar;
import androidx.annotation.NonNull;

import com.qualcomm.robotcore.hardware.I2cAddr;
import com.qualcomm.robotcore.hardware.I2cDeviceSynch;
import com.qualcomm.robotcore.hardware.I2cDeviceSynchDevice;
import com.qualcomm.robotcore.hardware.configuration.annotations.DeviceProperties;
import com.qualcomm.robotcore.hardware.configuration.annotations.I2cDeviceType;

@I2cDeviceType
@DeviceProperties(name = "I2cPort", xmlTag = "i2cport")
public class I2cPort extends I2cDeviceSynchDevice<I2cDeviceSynch> {
    private I2cAddr _i2cAddress = null;

    public void initWithI2cAddress(@NonNull I2cAddr address){
        _i2cAddress = address;

        deviceClient.setI2cAddress(address);
    }

    public I2cPort(I2cDeviceSynch i2cDeviceSynch, boolean deviceClientIsOwned) {
        super(i2cDeviceSynch, deviceClientIsOwned);

        deviceClient.setReadWindow(new I2cDeviceSynch.ReadWindow(0, 26, I2cDeviceSynch.ReadMode.REPEAT));

        registerArmingStateCallback(false);
        deviceClient.engage();
    }

    public void write(byte... bytes){
        deviceClient.write(bytes);
    }

    public byte[] read(int lenght){
        return deviceClient.read(lenght);
    }

    public byte read(){
        return read(1)[0];
    }

    @Override
    protected boolean doInitialize() {
        return true;
    }

    @Override
    public Manufacturer getManufacturer() {
        return Manufacturer.Other;
    }

    @Override
    public String getDeviceName() {
        return "I2cPort";
    }
}
