package innerclasses;


import innerclasses.GreenhouseControls.Terminate;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/13 8:29 下午
 */

public class GreenhoseController {
    public static void main(String[] args) {
        GreenhouseControls gc = new GreenhouseControls();
        // Instead of using code, you could parse
        // configuration information from a text file:
        // 可以使用文本文件来进行配置 而不是使用代码

        gc.addEvent(gc.new Bell(900)); // 添加一个打铃事件

        Event[] eventList = {
                gc.new ThermostatNight(0),
                gc.new LightOn(200),
                gc.new LightOff(400),
                gc.new WaterOn(600),
                gc.new WaterOff(800),
                gc.new ThermostatDay(1400)
        };
        gc.addEvent(gc.new Restart(2000, eventList));

        gc.addEvent(new Terminate(5000));

        gc.run();
    }
}
