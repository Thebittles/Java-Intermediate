public class HourlyWorker extends Employee {
    private double hoursWorked;
    private double grossPay;

    // Constructor to initialize the hourly worker with validation
    public HourlyWorker(String name, int empID, double rate, double hours) {
        super(empID, name, rate);

        // Validate hours worked must be between 0 and 80
        if (hours < 0 || hours > 80) {
            throw new IllegalArgumentException("Hours worked must be between 0 and 80.");
        }

        this.hoursWorked = hours;
        this.grossPay = 0; // Default initialization for grossPay
    }

    // Setter for hoursWorked with validation
    public void setHours(double hours) {
        if (hours < 0 || hours > 80) {
            throw new IllegalArgumentException("Hours worked must be between 0 and 80.");
        }
        this.hoursWorked = hours;
    }

    // Getter for hoursWorked
    public double getHours() {
        return this.hoursWorked;
    }

    // Calculate gross pay considering overtime
    @Override
    public void calcGrossPay() {
        double payRate = getPayRate(); // Get the hourly rate from superclass
        if (hoursWorked <= 40) {
            // No overtime
            this.grossPay = payRate * hoursWorked;
        } else {
            // Calculate overtime pay
            double regularPay = 40 * payRate;
            double overtimeHours = hoursWorked - 40;
            double overtimePay = overtimeHours * payRate * 1.5;
            this.grossPay = regularPay + overtimePay;
        }
    }

    // Calculate net pay with tax of 8.25% on gross pay over $1250.65
    @Override
    public double calcNetPay() {
        double threshold = 1250.65;
        double taxRate = 0.0825;
        
        if (grossPay > threshold) {
            double taxableAmount = grossPay - threshold;
            return grossPay - (taxableAmount * taxRate);
        } else {
            return grossPay; // No tax if under the threshold
        }
    }

    // Override toString to display the desired format
    @Override
    public String toString() {
        // Use superclass information and append additional details
        return String.format(
            "%s%nHours Worked: %.2f%nGross Pay: %.2f%nNet Pay: %.2f",
            super.toString(),
            getHours(),
            grossPay,
            calcNetPay()
        );
    }
}