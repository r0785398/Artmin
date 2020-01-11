// BRAM 21/12/2019
// Fout bij deserialize van opvragen alle events uit database.
package artmin.model;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Rei
 */
@Entity
@Table(name = "events")
public class Event implements Serializable, Comparable<Event> {
    //    Attributen

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Transient
    private String statusText; // Satus text == niet in database

    @Transient
    private String statusColor; // Kleurcode status == niet in database

    @Column(name = "artistID", nullable = false, insertable = false, updatable = false)
    private Long artistID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artistID") // Object link naar Database ID
    private Artist artist;

    @NotEmpty
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "EventTypeID", nullable = false, insertable = false, updatable = false)
    private Long eventTypeID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EventTypeID") // Object link naar Database ID
    private EventType eventType;

    @Transient
    private int aantalNotes;

    @Transient
    private int aantalTodo;

    @Transient
    private int aantalTodoAck;

    @Column(name = "todoAck", nullable = true)
    private boolean todoAck;

    @Column(name = "dateCalendar", nullable = true)
    private Date dateCalendar;

    @Column(name = "dateActStart", nullable = true)
    private Date dateActStart;

    @Column(name = "dateActEnd", nullable = true)
    private Date dateActEnd;

    @Column(name = "dateAck", nullable = true)
    private boolean dateAck;

    @Column(name = "confirmedAck", nullable = true)
    private boolean confirmedAck;

    @Column(name = "locationID")
    private Long locationID;

    @Transient
    private EventLocation location;

    @Column(name = "locationAck", nullable = true)
    private boolean locationAck;

    @Column(name = "clientID")
    private Long clientID;

    @Transient
    private Client client;

    @Column(name = "clientAck", nullable = true)
    private boolean clientAck;

    @Column(name = "crowdQty", nullable = true)
    private int crowdQty;

    @Column(name = "crowdsAvgAge", nullable = true)
    private int crowdsAvgAge;

    @Column(name = "crowdInformation", nullable = true)
    private String crowdInformation;

    @Column(name = "crowdAck", nullable = true)
    private boolean crowdAck;

    @Column(name = "canceledAck", nullable = true)
    private boolean canceledAck;

    @Transient
    private int aantalPayments;

    @Transient
    private int aantalPaymentsAck;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "eventID")
    private Set<Note> notes;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "eventID")
    private Set<Payment> payments;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "eventID")
    private Set<Todo> todos;

//    Properties
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatusText() {
        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    public String getStatusColor() {
        return statusColor;
    }

    public void setStatusColor(String statusColor) {
        this.statusColor = statusColor;
    }

    public int getAantalNotes() {
        return aantalNotes;
    }

    public void setAantalNotes(int aantalNotes) {
        this.aantalNotes = aantalNotes;
    }

    public Long getArtistID() {
        return artistID;
    }

    public Long getEventTypeID() {
        return eventTypeID;
    }

    public void setEventTypeID(Long eventTypeID) {
        this.eventTypeID = eventTypeID;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public void setArtistID(Long artistID) {
        this.artistID = artistID;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isTodoAck() {
        return todoAck;
    }

    public int getAantalTodo() {
        return aantalTodo;
    }

    public void setAantalTodo(int aantalTodo) {
        this.aantalTodo = aantalTodo;
    }

    public int getAantalTodoAck() {
        return aantalTodoAck;
    }

    public void setAantalTodoAck(int aantalTodoAck) {
        this.aantalTodoAck = aantalTodoAck;
    }

    public void setTodoAck(boolean todoAck) {
        this.todoAck = todoAck;
    }

    public Date getDateCalendar() {
        return dateCalendar;
    }

    public void setDateCalendar(Date dateCalendar) {
        this.dateCalendar = dateCalendar;
    }

    public Date getDateActStart() {
        return dateActStart;
    }

    public void setDateActStart(Date dateActStart) {
        this.dateActStart = dateActStart;
    }

    public Date getDateActEnd() {
        return dateActEnd;
    }

    public void setDateActEnd(Date dateActEnd) {
        this.dateActEnd = dateActEnd;
    }

    public boolean isDateAck() {
        return dateAck;
    }

    public void setDateAck(boolean dateAck) {
        this.dateAck = dateAck;
    }

    public boolean isConfirmedAck() {
        return confirmedAck;
    }

    public void setConfirmedAck(boolean confirmedAck) {
        this.confirmedAck = confirmedAck;
    }

    public Long getLocationID() {
        return locationID;
    }

    public void setLocationID(Long locationID) {
        this.locationID = locationID;
    }

    public EventLocation getLocation() {
        return location;
    }

    public void setLocation(EventLocation location) {
        this.location = location;
    }

    public boolean isLocationAck() {
        return locationAck;
    }

    public void setLocationAck(boolean locationAck) {
        this.locationAck = locationAck;
    }

    public Long getClientID() {
        return clientID;
    }

    public void setClientID(Long clientID) {
        this.clientID = clientID;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public boolean isClientAck() {
        return clientAck;
    }

    public void setClientAck(boolean clientAck) {
        this.clientAck = clientAck;
    }

    public int getCrowdQty() {
        return crowdQty;
    }

    public void setCrowdQty(int crowdQty) {
        this.crowdQty = crowdQty;
    }

    public int getCrowdsAvgAge() {
        return crowdsAvgAge;
    }

    public void setCrowdsAvgAge(int crowdsAvgAge) {
        this.crowdsAvgAge = crowdsAvgAge;
    }

    public String getCrowdInformation() {
        return crowdInformation;
    }

    public void setCrowdInformation(String crowdInformation) {
        this.crowdInformation = crowdInformation;
    }

    public boolean isCrowdAck() {
        return crowdAck;
    }

    public void setCrowdAck(boolean crowdAck) {
        this.crowdAck = crowdAck;
    }

    public Set<Note> getNotes() {
        return notes;
    }

    public void setNotes(Set<Note> notes) {
        this.notes = notes;
    }

    public Set<Payment> getPayments() {
        return payments;
    }

    public void setPayments(Set<Payment> payments) {
        this.payments = payments;
    }

    public Set<Todo> getTodos() {
        return todos;
    }

    public void setTodos(Set<Todo> todos) {
        this.todos = todos;
    }

    public boolean isCanceledAck() {
        return canceledAck;
    }

    public void setCanceledAck(boolean canceledAck) {
        this.canceledAck = canceledAck;
    }

    public int getAantalPayments() {
        return aantalPayments;
    }

    public void setAantalPayments(int aantalPayments) {
        this.aantalPayments = aantalPayments;
    }

    public int getAantalPaymentsAck() {
        return aantalPaymentsAck;
    }

    public void setAantalPaymentsAck(int aantalPaymentsAck) {
        this.aantalPaymentsAck = aantalPaymentsAck;
    }

    public void statusSwitch() {
        // Instellen van de status

        if (this.isCanceledAck() == true) {
            // Event is geanulleerd
            this.setStatusText("CANCELLED");
            this.setStatusColor("badge-danger");

        } else {

            if (this.isConfirmedAck() == true) {
                // Event is bevestigd
                if ((this.isTodoAck() == true) && (this.isDateAck() == true) && (this.isLocationAck() == true) && (this.isClientAck() == true) && (this.isCrowdAck() == true)) {
                    // Event is compleet
                    this.setStatusText("READY2PLAY");
                    this.setStatusColor("badge-success");
                } else {
                    // Event is niet volledig
                    this.setStatusText("INCOMPLETE");
                    this.setStatusColor("badge-warning");
                }

            } else {
                // Event is niet bevestigd = optie
                this.setStatusText("OPTION");
                this.setStatusColor("badge-primary");

            }
        }
    }

//    Methodes
    @Override
    public int hashCode() {
        final int prime = 31;
        long result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return (int) result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Event)) {
            return false;
        }
        Event other = (Event) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Event [id=" + id + ", name=" + name + "]";
    }

    public boolean SetEventDate(EventDate edate) {
        try {

            // SET CALENDAR DATE
            this.setDateCalendar(stringToDate(edate.getCalendarDate()));
            if (this.getDateCalendar() == null) {
                return false;
            }

            // SET ACT START DATE
            this.setDateActStart(stringToDate(edate.getActStart()));
            if (this.getDateActStart() == null) {
                return false;
            }

            // SET ACT END DATE
            // SET ACT START DATE
            this.setDateActEnd(stringToDate(edate.getActEnd()));
            if (this.getDateActEnd() == null) {
                return false;
            }

            this.setDateAck(edate.isAck());

            return true; // Alles is goed verlopen

        } catch (Exception e) {
            return false;
        }
    }

    private Date stringToDate(StringDate sdate) {
        // Parse string to Date
        String year = Integer.toString(sdate.getYear());
        String month = formatValue(sdate.getMonth());
        String day = formatValue(sdate.getDay());
        String hour = formatValue(sdate.getHour());
        String min = formatValue(sdate.getMin());

        try {
            // String (datum) samenstellen
            String dateTime = day + "-" + month + "-" + year + " " + hour + ":" + min + ":00";

            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

            return format.parse(dateTime);

        } catch (Exception e) {
            return null;
        }
    }

    private String formatValue(int value) {
        // Als de value kleiner is dan 10, een "0" vooraan toevoegen
        if (value < 10) {
            return "0" + Integer.toString(value);
        } else {
            return Integer.toString(value);
        }
    }

    public EventDate getStringDates() {
        // Instance
        EventDate ed = new EventDate();

        if (this.getDateCalendar() != null) {
            ed.setCalendarDate(dateFromString(this.getDateCalendar()));
        }

        if (this.getDateActStart() != null) {
            ed.setActStart(dateFromString(this.getDateActStart()));
        }

        if (this.getDateActEnd() != null) {
            ed.setActEnd(dateFromString(this.getDateActEnd()));
        }

        ed.setAck(this.isDateAck()); // Set Ac

        return ed;
    }

    private StringDate dateFromString(Date value) {
        // get date string
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String strDate = dateFormat.format(value);

        String sss = strDate.substring(5, 7);

        // instance of stringdate
        StringDate sd = new StringDate();
        sd.setYear(Integer.parseInt(strDate.substring(0, 4)));
        sd.setMonth(Integer.parseInt(strDate.substring(5, 7)));
        sd.setDay(Integer.parseInt(strDate.substring(8, 10)));

        sd.setHour(Integer.parseInt(strDate.substring(11, 13)));
        sd.setMin(Integer.parseInt(strDate.substring(14, 16)));

        return sd;
    }

    @Override
    public int compareTo(Event evt) {
        // Sorteren op act start tijd
        if (this.getDateActStart() == null || evt.getDateActStart() == null) {
            return 0;
        }
        return this.getDateActStart().compareTo(evt.getDateActStart());
    }

}
