package net;

import com.google.gson.Gson;
import net.entity.Driver;
import net.entity.Truck;
import net.service.DriverService;
import net.service.DriverServiceImpl;
import net.service.TruckService;
import net.service.TruckServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ServletDriver extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
        EntityManagerProvider.init();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException,
            java.io.IOException {
        Gson gson = new Gson();
        DriverService drivers = new DriverServiceImpl();
        if(request.getInputStream().available() !=0 ){
            InputStream getJson = request.getInputStream();
            Driver driver = gson.fromJson(new InputStreamReader(getJson), Driver.class);
            drivers.createDriver(driver);
        }
    }

    @Override
    protected  void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException{
        Gson gson = new Gson();
        DriverService driverService = new DriverServiceImpl();
        String driverString = gson.toJson(driverService.findAll());
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(driverString);
    }

    @Override
    public void destroy() {
        super.destroy();
        EntityManagerProvider.destroy();
    }
}
