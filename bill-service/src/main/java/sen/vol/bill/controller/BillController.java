package sen.vol.bill.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sen.vol.bill.controller.dto.BillRequestDTO;
import sen.vol.bill.controller.dto.BillResponseDTO;
import sen.vol.bill.service.BillService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class BillController {

    @Autowired
    private final BillService billService;

    public BillController(BillService billService) {
        this.billService = billService;
    }

    @GetMapping("/{billId}")
    public BillResponseDTO getBill(@PathVariable Long billId){
        return new BillResponseDTO(billService.getBillById(billId));
    }

    @PostMapping("/")
    public Long createBill(@RequestBody BillRequestDTO requestDTO){
        return billService.createBill(requestDTO.getAccountId(), requestDTO.getAmount(), requestDTO.getIsDefault(),
                requestDTO.getOverdraftEnabled());
    }

    @PutMapping("/{billId}")
    public BillResponseDTO updateBill(@PathVariable Long billId, @RequestBody BillRequestDTO requestDTO){
        return new BillResponseDTO(billService.updateBill(billId, requestDTO.getAccountId(), requestDTO.getAmount(),
                requestDTO.getIsDefault(), requestDTO.getOverdraftEnabled()));
    }

    @DeleteMapping("/{billId}")
    public BillResponseDTO deleteBill(@PathVariable Long billId){
        return new BillResponseDTO(billService.deleteBill(billId));
    }

    @GetMapping("/account/{accountId}")
    public List<BillResponseDTO> getBillsByAccountId(@PathVariable Long accountId){
        return billService.getBillsByAccountId(accountId).stream()
                .map(BillResponseDTO::new)
                .collect(Collectors.toList());
    }

}
