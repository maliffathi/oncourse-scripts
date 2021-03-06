import java.time.LocalDate
import java.time.Period

def run(args) {

    def context = args.context

    def today = LocalDate.now()
    def plusWeek = today.plusDays(7)

    def invoices = ObjectSelect.query(Invoice)
            .where(Invoice.AMOUNT_OWING.gt(Money.ZERO))
            .and(Invoice.DATE_DUE.lte(plusWeek))
            .select(context)

    invoices.findAll { i ->
        plusWeek.isEqual(i.dateDue) || // 7 days before the payment due date
                today.isEqual(i.dateDue) || // day the payment is due
                ((Period.between(today, i.dateDue).days % 7 == 0) && i.overdue.isGreaterThan(Money.ZERO)) // every 7 days of overdue
    }.each { i ->
        email {
            template "Payment reminder"
            bindings invoice: i
            to i.contact
        }
    }
}