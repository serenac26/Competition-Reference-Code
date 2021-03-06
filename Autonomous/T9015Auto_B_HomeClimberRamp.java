package com.qualcomm.ftcrobotcontroller.opmodes;

/**
 * Autonomous program for putting climbers in the shelter and going up the blue ramp on home side
 *
 * Key point: Robot is programmed to go forward in front of the ramp and backwards to ensure there is no debris blocking the turn path
 *
 *
 * Created by seren_000 on 12/29/2015.
 */

public class T9015Auto_B_HomeClimberRamp extends T9015Hardware {
    private int v_state;
    private boolean v_inState;
    //private boolean v_forward;
    //private boolean v_turn_left;

    private double degrees = 0;
    private double distance = 0;
    private double power = 0;

    public T9015Auto_B_HomeClimberRamp(){

    }

    @Override
    public void init(){
        super.init();
        v_state = 0;
        v_inState = false;
    }

    @Override
    public void loop(){
        switch(v_state) {
            case 0:
                telemetry.addData("0 - ","init");
                // Reset the encoders to ensure they are at a known good value.
                reset_drive_encoders();
                set_servo_down(); //servo is connected to plate that deflects debris from wheels
                move_to_next_state();
                break;
            case 1:
                //only need to initialize encoders on first time in state
                if (first_time_in_state()) {
                    run_using_encoders();
                    go_forward(); //set direction forward
                }
                distance = 30; //set distance to move (cm)
                power    = 0.3; //set power
                telemetry.addData("1 - ", "forward=" + distance + "p=" + power); //displays distance and power to phone screen
                if (has_driver_moved_cm(distance, power)) //when encoder has reached corresponding ticks for set distance move to the next state
                    move_to_next_state();
                break;
            case 2:
                // allow the encoder to reset
                if (have_drive_encoders_reset())
                    move_to_next_state();
                break;
            case 3:
                //only need to initialize encoders on first time in state
                if (first_time_in_state()) {
                    run_using_encoders();
                    turn_right(); //set direction to turn left
                }
                degrees    = 45; //set turn degree
                power = 0.3; //set power
                telemetry.addData("2 - ", "turn_right=" + degrees + "p=" + power); //displays distance and power to phone screen
                if (has_driver_turned_degrees(degrees, power)) //when encoder has reached given number of ticks corresponding to given degree measure move to next state
                    move_to_next_state();
                break;
            case 4:
                // allow the encoder to reset
                if (have_drive_encoders_reset())
                    move_to_next_state();
                break;
            case 5:
                //only need to initialize encoders on first time in state
                if (first_time_in_state()) {
                    run_using_encoders();
                    go_forward(); //set direction forward
                }
                distance = 120;  //set distance to move (cm)
                power    = 0.3;  //set power
                telemetry.addData("3 - ","forward=" + distance + "p=" + power); //displays distance and power to phone screen
                if (has_driver_moved_cm(distance, power)) //when encoder has reached corresponding ticks for set distance move to the next state
                    move_to_next_state();
                break;
            case 6:
                // allow the encoder to reset
                if (have_drive_encoders_reset())
                    move_to_next_state();
                break;
            case 7:
                //only need to initialize encoders on first time in state
                if (first_time_in_state()) {
                    run_using_encoders();
                    turn_left(); //set direction to turn left
                }
                degrees    = 45;  //set turn degree
                power    = 0.3;  //set power
                telemetry.addData("5 - ", "turn_left=" + degrees + "p=" + power); //displays distance and power to phone screen
                if (has_driver_turned_degrees(degrees, power)) //when encoder has reached given number of ticks corresponding to given degree measure move to next state
                    move_to_next_state();
                break;
            case 8:
                // allow the encoder to reset
                if (have_drive_encoders_reset())
                    move_to_next_state();
                break;
            case 9:
                //only need to initialize encoders on first time in state
                if (first_time_in_state()) {
                    run_using_encoders();
                    go_forward(); //set direction forward
                }
                distance = 10;  //set distance to move (cm)
                power    = 0.3;  //set power
                telemetry.addData("3 - ","forward=" + distance + "p=" + power); //displays distance and power to phone screen
                if (has_driver_moved_cm(distance, power)) //when encoder has reached corresponding ticks for set distance move to the next state
                    move_to_next_state();
                break;
            case 10:
                // allow the encoder to reset
                if (have_drive_encoders_reset())
                    move_to_next_state();
                break;
            case 11:
                //only need to initialize encoders on first time in state
                if (first_time_in_state()) {
                    run_using_encoders();
                    turn_right(); //set direction to turn left
                }
                degrees    = 90; //set turn degree
                power = 0.3; //set power
                telemetry.addData("2 - ", "turn_right=" + degrees + "p=" + power); //displays distance and power to phone screen
                if (has_driver_turned_degrees(degrees, power)) //when encoder has reached given number of ticks corresponding to given degree measure move to next state
                    move_to_next_state();
                break;
            case 12:
                // allow the encoder to reset
                if (have_drive_encoders_reset())
                    move_to_next_state();
                break;
            case 13:
                //only need to initialize encoders on first time in state
                if (first_time_in_state()) {
                    run_using_encoders();
                    go_forward(); //set direction forward
                }
                distance = 10;  //set distance to move (cm)
                power    = 0.3;  //set power
                telemetry.addData("3 - ","forward=" + distance + "p=" + power); //displays distance and power to phone screen
                if (has_driver_moved_cm(distance, power)) //when encoder has reached corresponding ticks for set distance move to the next state
                    move_to_next_state();
                break;
            case 14:
                // allow the encoder to reset
                if (have_drive_encoders_reset())
                    move_to_next_state();
                break;
            case 15:
                for(int i = 0; i < 500; i++){
                    set_hang_power(0.6);
                }
                telemetry.addData("4 - ","hang=" + power); //displays power to phone screen
                move_to_next_state();
                break;
            case 16:
                // allow the encoder to reset
                if (have_drive_encoders_reset())
                    move_to_next_state();
                break;
            case 17:
                for(int i = 0; i < 500; i++){
                    set_hang_power(-0.6);
                }
                telemetry.addData("4 - ","hang=" + power); //displays power to phone screen
                move_to_next_state();
                break;
            case 18:
                // allow the encoder to reset
                if (have_drive_encoders_reset())
                    move_to_next_state();
                break;
            case 19:
                //only need to initialize encoders on first time in state
                if (first_time_in_state()) {
                    run_using_encoders();
                    go_backward(); //set direction forward
                }
                distance = 10;  //set distance to move (cm)
                power    = 0.3;  //set power
                telemetry.addData("3 - ","backward=" + distance + "p=" + power); //displays distance and power to phone screen
                if (has_driver_moved_cm(distance, power)) //when encoder has reached corresponding ticks for set distance move to the next state
                    move_to_next_state();
                break;
            case 20:
                // allow the encoder to reset
                if (have_drive_encoders_reset())
                    move_to_next_state();
                break;
            case 21:
                //only need to initialize encoders on first time in state
                if (first_time_in_state()) {
                    run_using_encoders();
                    turn_left(); //set direction to turn left
                }
                degrees    = 45; //set turn degree
                power = 0.3; //set power
                telemetry.addData("2 - ", "turn_left=" + degrees + "p=" + power); //displays distance and power to phone screen
                if (has_driver_turned_degrees(degrees, power)) //when encoder has reached given number of ticks corresponding to given degree measure move to next state
                    move_to_next_state();
                break;
            case 22:
                // allow the encoder to reset
                if (have_drive_encoders_reset())
                    move_to_next_state();
                break;
            case 23:
                //only need to initialize encoders on first time in state
                if (first_time_in_state()) {
                    run_using_encoders();
                    go_backward(); //set direction forward
                }
                distance = 60;  //set distance to move (cm)
                power    = 0.3;  //set power
                telemetry.addData("3 - ","backward=" + distance + "p=" + power); //displays distance and power to phone screen
                if (has_driver_moved_cm(distance, power)) //when encoder has reached corresponding ticks for set distance move to the next state
                    move_to_next_state();
                break;
            case 24:
                // allow the encoder to reset
                if (have_drive_encoders_reset())
                    move_to_next_state();
                break;
            case 25:
                //only need to initialize encoders on first time in state
                if (first_time_in_state()) {
                    run_using_encoders();
                    turn_right(); //set direction to turn left
                }
                degrees    = 90; //set turn degree
                power = 0.3; //set power
                telemetry.addData("2 - ", "turn_right=" + degrees + "p=" + power); //displays distance and power to phone screen
                if (has_driver_turned_degrees(degrees, power)) //when encoder has reached given number of ticks corresponding to given degree measure move to next state
                    move_to_next_state();
                break;
            case 26:
                // allow the encoder to reset
                if (have_drive_encoders_reset())
                    move_to_next_state();
                break;
            case 27:
                //only need to initialize encoders on first time in state
                if (first_time_in_state()) {
                    run_using_encoders();
                    go_forward();  //set direction backward
                    set_servo_up();
                }
                distance = 120;  //set distance to move (cm)
                power    = 0.8;  //set power
                telemetry.addData("6 - ","forward=" + distance + "p=" + power); //displays distance and power to phone screen
                if (has_driver_moved_cm(distance, power)) //when encoder has reached corresponding ticks for set distance move to the next state
                    move_to_next_state(); //moves to final default state and ends program
                break;
            default:
                //
                // The autonomous actions have been accomplished (i.e. the state has
                // transitioned into its final state.
                //
                break;
        }

    }

    //move to next state in switch loop
    void move_to_next_state(){
        v_state++;
        v_inState = false;
    }

    //check if first time in current state
    boolean first_time_in_state(){
        boolean firstTime = v_inState == false;
        v_inState = true;
        return firstTime;
    }
}
