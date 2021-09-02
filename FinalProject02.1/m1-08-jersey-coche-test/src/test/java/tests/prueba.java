package tests;

import java.io.*;

import com.example.demo.domain.vehicles.CombustionVehicle;
import com.example.demo.domain.pieces.Battery;
import com.example.demo.domain.pieces.AirConditioning;
import com.example.demo.domain.pieces.Engine;
import com.example.demo.domain.pieces.Injection;
import com.example.demo.service.CombustionVehicleServiceImpl;

public class prueba {
	static CombustionVehicleServiceImpl veh = new CombustionVehicleServiceImpl();
	
	public static void main(String[] args)
    {
        System.out.println(veh.findOne(1L).getAirAc().getStatusAirConditioning());
        System.out.println(veh.findByOnOff(true));
        System.out.println();
    }
}


