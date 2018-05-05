package net;

import com.google.gson.Gson;
import net.entity.Truck;
import net.service.TruckService;
import net.service.TruckServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ServletTruck extends HttpServlet{

    @Override
    public void init() throws ServletException {
        super.init();
        EntityManagerProvider.init();
    }

    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,
            java.io.IOException {
        Gson gson = new Gson();
        TruckService trucks = new TruckServiceImpl();
        if(request.getInputStream().available() !=0 ){
            InputStream getJson = request.getInputStream();
            Truck truck = gson.fromJson(new InputStreamReader(getJson), Truck.class);
            trucks.createTruck(truck);
        }
    }

    @Override
    protected  void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException{
        Gson gson = new Gson();
        TruckService trucks = new TruckServiceImpl();
        String truckString = gson.toJson(trucks.findAll());
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(truckString);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse responce)
            throws ServletException, java.io.IOException{
        Gson gson = new Gson();
        TruckService truckService = new TruckServiceImpl();
        String idStringTruck = request.getPathInfo().substring(1);
        int idTruck = Integer.parseInt(idStringTruck);
        truckService.delete(idTruck);
        responce.setStatus(HttpServletResponse.SC_OK);
        }

    @Override
    public void destroy() {
        super.destroy();
        EntityManagerProvider.destroy();
    }
}

