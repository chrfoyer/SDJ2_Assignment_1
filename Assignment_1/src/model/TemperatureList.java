package model;

import java.util.ArrayList;

public class TemperatureList
{
   private ArrayList<Double> list;

   public TemperatureList()
   {
      this.list = new ArrayList<>();
   }

   public void addTemperature(Double temperature)
   {
      list.add(temperature);
   }

   public Double getLastTemperature()
   {
      return list.get(getSize());
   }


   public int getSize()
   {
      return list.size();
   }

   public String toString()
   {
      String s = "{";
      for (int i = 0; i < list.size(); i++)
      {
         s += list.get(i);
         if (i < list.size() - 1)
         {
            s += ", ";
         }
      }
      return s;
   }
}
