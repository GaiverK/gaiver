package com.konstantin;

public class worker {

    public String getMaxNum(int num1, int num2){
        if( num1 == num2 ) return "equal";
        else if( num1 > num2 ) return "Максимальное число = " + num1;
        else  return "Максимальное число = " + num2;
    }

    public String getCentury(int year){
        int century = year / 100;

        if( century % 100 != 0 ){
            century++;
        }
        return year + " год --- это " + century + " век";
    }

    public String isLeapYear(int year){
        if( year % 4 == 0 && year % 100 != 0 || year % 400 == 0 ){
            return "Год " + year + " високосный";
        }else return "Год " + year + " не високосный";
    }

    public int getNumSumm(int num){
        if( num < 10 ) return num;
        else return getNumSumm(num / 10) + num % 10;
    }

    public String divisibleByThree(String num){
        int repeater = 0;
        int strNumSumma = 0;
        while( repeater < num.length() ){
            strNumSumma += num.charAt(repeater++);
        }
        if( strNumSumma % 3 == 0 ) return "Число " + num + " делится на 3";
        else return "Число " + num + " не делится на 3 без остатка";
    }

    public String formatInterval(int interval){
        int hours = 0;
        int minutes = 0;
        int seconds = 0;
        String time_result = "";
        // Определяем час
        if( (double)interval / 3600 >= 1 ){
            hours = interval / 3600;
            time_result += hours + " " + declension(hours, new String[]{"час", "часа", "часов"}) + " ";
            interval -= hours * 3600;
        }
        // Определяем минуты
        if( (double)interval / 60 >= 1 ){
            minutes = interval / 60;
            time_result += minutes + " " + declension(minutes, new String[]{"минута", "минуты", "минут"}) + " ";
            interval -= minutes * 60;
        }
        // Определяем секунды
        if( interval > 0 ){
            seconds = interval;
            time_result += seconds + " " + declension(seconds, new String[]{"секунда", "секунды", "секунд"});
        }

        return time_result;
    }

    private String declension(long value, String[] words) {
        String result = "";
        long count = value % 100;
        if (count >= 5 && count <= 20) {
            result = words[2];
        } else {
            count = count % 10;
            if (count == 1) {
                result = words[0];
            } else if (count >= 2 && count <= 4) {
                result = words[1];
            } else {
                result = words[2];
            }
        }
        return result;
    }
}
