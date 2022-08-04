package sen.vol.bill.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import sen.vol.bill.entity.Bill;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@AllArgsConstructor
@Getter
public class BillResponseDTO {

    private Long billId;

    private Long accountId;

    private BigDecimal amount;

    private Boolean isDefault;

    private OffsetDateTime creationTime;

    private Boolean overdraftEnabled;

    public BillResponseDTO(Bill bill){
        billId = bill.getBillId();
        accountId = bill.getAccountId();
        amount = bill.getAmount();
        isDefault = bill.getIsDefault();
        creationTime = bill.getCreationTime();
        overdraftEnabled = bill.getOverdraftEnabled();
    }
}
