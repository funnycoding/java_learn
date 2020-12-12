package innerclasses;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/13 8:03 下午
 */

public class GreenhouseControls extends Controller {
    private boolean light = false;

    public class LightOn extends Event {

        public LightOn(long millisecondDelay) {
            super(millisecondDelay);
        }

        // Put hardware control code here to
        // physically turn on the light.
        // 开灯控制器
        @Override
        public void action() {
            light = true;
        }

        @Override
        public String toString() {
            return "Light is on";
        }
    }

    // 关灯控制器
    public class LightOff extends Event {
        public LightOff(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            // Put hardware control code here to
            // physically turn off the light.
            light = false;
        }

        @Override
        public String toString() {
            return "Light is off";
        }
    }

    // 水的状态和 开水/关水 控制器
    private boolean water = false;

    public class WaterOn extends Event {
        public WaterOn(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            // Put hardware control code here.
            water = true;
        }

        @Override
        public String toString() {
            return "Greenhouse water is on";
        }
    }

    public class WaterOff extends Event {
        public WaterOff(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            // Put hardware control code here.
            water = false;
        }

        @Override
        public String toString() {
            return "Greenhouse water is off";
        }
    }

    // 恒温器
    private String thermostat = "Day";

    public class ThermostatNight extends Event {
        public ThermostatNight(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            // Put hardware control code here.
            thermostat = "Night";
        }

        @Override
        public String toString() {
            return "Thermostat on night setting";
        }
    }

    public class ThermostatDay extends Event {
        public ThermostatDay(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            // Put hardware control code here.
            thermostat = "Day";
        }

        @Override
        public String toString() {
            return "Thermostat on day setting";
        }
    }

    public class Bell extends Event {
        public Bell(long delayTime) {
            super(delayTime);
        }
        @Override
        public void action() {
            addEvent(new Bell(delayTime.toMillis()));
        }
        @Override
        public String toString() {
            return "Bing!";
        }
    }



    public class Restart extends Event {
        private Event[] eventList;

        // 重新启动方法，将执行过的 Event 重新放入 事件列表中
        public Restart(long millisecondDelay, Event[] eventList) {
            super(millisecondDelay);
            this.eventList = eventList;
            for (Event event : eventList) {
                addEvent(event);
            }
        }

        @Override
        public void action() {
            for (Event e : eventList) {
                e.start(); // Return each event
                addEvent(e);
            }
            start(); // Return this Event
            addEvent(this);
        }

        @Override
        public String toString() {
            return "Restarting System";
        }
    }

    // 退出控制器
    public static class Terminate extends Event {
        public Terminate(long millisecondDelay) {
            super(millisecondDelay);
        }

        @Override
        public void action() {
            System.exit(0);
        }

        @Override
        public String toString() {
            return "Terminating";
        }
    }

}
