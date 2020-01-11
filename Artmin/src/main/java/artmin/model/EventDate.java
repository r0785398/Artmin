/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package artmin.model;

/**
 *
 * @author work
 */
public class EventDate {

    private StringDate calendarDate;
    private StringDate actStart;
    private StringDate actEnd;
    private boolean ack;

    public EventDate() {
        calendarDate = new StringDate();
        actStart = new StringDate();
        actEnd = new StringDate();
    }

    public StringDate getCalendarDate() {
        return calendarDate;
    }

    public void setCalendarDate(StringDate calendarDate) {
        this.calendarDate = calendarDate;
    }

    public StringDate getActStart() {
        return actStart;
    }

    public void setActStart(StringDate actStart) {
        this.actStart = actStart;
    }

    public StringDate getActEnd() {
        return actEnd;
    }

    public void setActEnd(StringDate actEnd) {
        this.actEnd = actEnd;
    }

    public boolean isAck() {
        return ack;
    }

    public void setAck(boolean ack) {
        this.ack = ack;
    }
    
}
