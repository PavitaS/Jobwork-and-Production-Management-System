package com.project.jobwork_production_management;
import entity.Customer;
import java.util.*;
import entity.Delivery;
import entity.Invoice;
import entity.JobOrder;
import entity.MaterialReceipt;
import entity.Payment;
import entity.Production;
import entity.QualityCheck;

import org.hibernate.*;

import service.CustomerService;
import service.DeliveryService;
import service.InvoiceService;
import service.JobOrderService;
import service.MaterialReceiptService;
import service.PaymentService;
import service.ProductionService;
import service.QualityCheckService;
public class App {
		static Scanner sc = new Scanner(System.in);
		static CustomerService customerService = new CustomerService();
		static JobOrderService jobOrderService = new JobOrderService();
		static MaterialReceiptService materialReceiptService = new MaterialReceiptService();
		static ProductionService productionService = new ProductionService();
		static QualityCheckService qualityCheckService = new QualityCheckService();
		static DeliveryService deliveryService = new DeliveryService();
		static InvoiceService invoiceService = new InvoiceService();
		static PaymentService paymentService = new PaymentService();
		 public static void main(String[] args) {
		        while (true) {
		            System.out.println("\n==========================================");
		            System.out.println("     JOB WORK & PRODUCTION MANAGEMENT");
		            System.out.println("==========================================");
		            System.out.println("1.  Add Customer");
		            System.out.println("2.  Create Job Order");
		            System.out.println("3.  Receive Material");
		            System.out.println("4.  Record Production");
		            System.out.println("5.  Quality Check");
		            System.out.println("6.  Delivery");
		            System.out.println("7.  Generate Invoice");
		            System.out.println("8.  Record Payment");
		            System.out.println("9.  View Customer");
		            System.out.println("10. View Job Order");
		            System.out.println("11. View Production");
		            System.out.println("12. View Invoice");
		            System.out.println("13. Update Customer");
		            System.out.println("14. Delete Customer");
		            System.out.println("0.  Exit");
		            System.out.println("==========================================");

		            System.out.print("Enter your choice: ");
		            int choice = sc.nextInt();
		            sc.nextLine();
		            switch (choice) {
		                case 1:
		                    addCustomer();
		                    break;
		                case 2:
		                    createJobOrder();
		                    break;
		                case 3:
		                    receiveMaterial();
		                    break;
		                case 4:
		                    recordProduction();
		                    break;
		                case 5:
		                    qualityCheck();
		                    break;
		                case 6:
		                    delivery();
		                    break;
		                case 7:
		                    generateInvoice();
		                    break;
		                case 8:
		                    recordPayment();
		                    break;
		                case 9:
		                    viewCustomer();
		                    break;
		                case 10:
		                    viewJobOrder();
		                    break;
		                case 11:
		                    viewProduction();
		                    break;
		                case 12:
		                    viewInvoice();
		                    break;
		                case 13:
		                    updateCustomer();
		                    break;
		                case 14:
		                    deleteCustomer();
		                    break;
		                case 0:
		                    System.out.println("Application closed.");
		                    sc.close();
		                    return;
		                default:
		                    System.out.println("Invalid choice.");
		            }
		        }
		    }
		    public static void addCustomer() {
		        System.out.println("\n--- Add Customer ---");
		        System.out.print("Enter name: ");
		        String name = sc.nextLine();
		        System.out.print("Enter phone number: ");
		        String phone = sc.nextLine();
		        System.out.print("Enter email: ");
		        String email = sc.nextLine();
		        System.out.print("Enter address: ");
		        String address = sc.nextLine();

		        Customer customer = new Customer(
		                name,
		                phone,
		                email,
		                address
		        );
		        Customer savedCustomer = customerService.saveCustomer(customer);
		        System.out.println("Customer saved successfully!");
		        System.out.println("Customer ID: " + savedCustomer.getId());
		    }
		    public static void createJobOrder() {
		        System.out.println("\n--- Create Job Order ---");
		        System.out.print("Enter Customer ID: ");
		        Long customerId = sc.nextLong();
		        sc.nextLine();
		        Customer customer = customerService.getCustomer(customerId);
		        if (customer == null) {
		            System.out.println("Customer not found.");
		            return;
		        }
		        System.out.print("Enter product name: ");
		        String productName = sc.nextLine();
		        System.out.print("Enter quantity: ");
		        int quantity = sc.nextInt();
		        System.out.print("Enter rate per piece: ");
		        double rate = sc.nextDouble();
		        sc.nextLine();
		        System.out.print("Enter status: ");
		        String status = sc.nextLine();
		        JobOrder jobOrder = new JobOrder(
		                customer,
		                productName,
		                quantity,
		                rate,
		                status
		        );
		        JobOrder savedJobOrder = jobOrderService.saveJobOrder(jobOrder);
		        System.out.println("Job Order created successfully!");
		        System.out.println("Job Order ID: " + savedJobOrder.getId());
		    }
		    public static void receiveMaterial() {
		        System.out.println("\n--- Receive Material ---");
		        System.out.print("Enter Job Order ID: ");
		        Long jobOrderId = sc.nextLong();
		        sc.nextLine();
		        JobOrder jobOrder = jobOrderService.getJobOrder(jobOrderId);
		        if (jobOrder == null) {
		            System.out.println("Job Order not found.");
		            return;
		        }
		        System.out.print("Enter received quantity: ");
		        int quantity = sc.nextInt();
		        sc.nextLine();
		        System.out.print("Enter received date: ");
		        String date = sc.nextLine();
		        System.out.print("Enter remarks: ");
		        String remarks = sc.nextLine();
		        MaterialReceipt receipt = new MaterialReceipt(
		                jobOrder,
		                quantity,
		                date,
		                remarks
		        );
		        MaterialReceipt savedReceipt =materialReceiptService.saveMaterialReceipt(receipt);
		        System.out.println("Material received successfully!");
		        System.out.println("Receipt ID: " + savedReceipt.getId());
		    }
		    public static void recordProduction() {
		        System.out.println("\n--- Record Production ---");
		        System.out.print("Enter Job Order ID: ");
		        Long jobOrderId = sc.nextLong();
		        sc.nextLine();
		        JobOrder jobOrder = jobOrderService.getJobOrder(jobOrderId);
		        if (jobOrder == null) {
		            System.out.println("Job Order not found.");
		            return;
		        }
		        System.out.print("Enter produced quantity: ");
		        int producedQuantity = sc.nextInt();
		        System.out.print("Enter pending quantity: ");
		        int pendingQuantity = sc.nextInt();
		        sc.nextLine();
		        System.out.print("Enter production date: ");
		        String date = sc.nextLine();
		        System.out.print("Enter remarks: ");
		        String remarks = sc.nextLine();
		        Production production = new Production(
		                jobOrder,
		                producedQuantity,
		                pendingQuantity,
		                date,
		                remarks
		        );
		        Production savedProduction =productionService.saveProduction(production);
		        System.out.println("Production recorded successfully!");
		        System.out.println("Production ID: " + savedProduction.getId());
		    }
		    public static void qualityCheck() {
		        System.out.println("\n--- Quality Check ---");
		        System.out.print("Enter Production ID: ");
		        Long productionId = sc.nextLong();
		        sc.nextLine();
		        Production production =productionService.getProduction(productionId);
		        if (production == null) {
		            System.out.println("Production record not found.");
		            return;
		        }
		        System.out.print("Enter good quantity: ");
		        int goodQuantity = sc.nextInt();
		        System.out.print("Enter rework quantity: ");
		        int reworkQuantity = sc.nextInt();
		        System.out.print("Enter scrap quantity: ");
		        int scrapQuantity = sc.nextInt();
		        sc.nextLine();
		        System.out.print("Enter check date: ");
		        String date = sc.nextLine();
		        System.out.print("Enter remarks: ");
		        String remarks = sc.nextLine();
		        QualityCheck qualityCheck = new QualityCheck(
		                production,
		                goodQuantity,
		                reworkQuantity,
		                scrapQuantity,
		                date,
		                remarks
		        );
		        QualityCheck savedQualityCheck =qualityCheckService.saveQualityCheck(qualityCheck);
		        System.out.println("Quality check recorded successfully!");
		        System.out.println("Quality Check ID: " + savedQualityCheck.getId());
		    }
		    public static void delivery() {
		        System.out.println("\n--- Delivery ---");
		        System.out.print("Enter Job Order ID: ");
		        Long jobOrderId = sc.nextLong();
		        sc.nextLine();
		        JobOrder jobOrder = jobOrderService.getJobOrder(jobOrderId);
		        if (jobOrder == null) {
		            System.out.println("Job Order not found.");
		            return;
		        }
		        System.out.print("Enter delivered quantity: ");
		        int quantity = sc.nextInt();
		        sc.nextLine();
		        System.out.print("Enter delivery date: ");
		        String date = sc.nextLine();
		        System.out.print("Enter delivery status: ");
		        String status = sc.nextLine();
		        System.out.print("Enter remarks: ");
		        String remarks = sc.nextLine();
		        Delivery delivery = new Delivery(
		                jobOrder,
		                quantity,
		                date,
		                status,
		                remarks
		        );
		        Delivery savedDelivery =deliveryService.saveDelivery(delivery);
		        System.out.println("Delivery recorded successfully!");
		        System.out.println("Delivery ID: " + savedDelivery.getId());
		    }
		    public static void generateInvoice() {
		        System.out.println("\n--- Generate Invoice ---");
		        System.out.print("Enter Job Order ID: ");
		        Long jobOrderId = sc.nextLong();
		        sc.nextLine();
		        JobOrder jobOrder = jobOrderService.getJobOrder(jobOrderId);
		        if (jobOrder == null) {
		            System.out.println("Job Order not found.");
		            return;
		        }
		        System.out.print("Enter billed quantity: ");
		        int billedQuantity = sc.nextInt();
		        sc.nextLine();
		        double totalAmount =billedQuantity * jobOrder.getRate();
		        System.out.println("Calculated invoice amount: ₹"+ totalAmount);
		        System.out.print("Enter invoice date: ");
		        String date = sc.nextLine();
		        System.out.print("Enter invoice status: ");
		        String status = sc.nextLine();
		        Invoice invoice = new Invoice(
		                jobOrder,
		                billedQuantity,
		                totalAmount,
		                date,
		                status
		        );
		        Invoice savedInvoice =invoiceService.saveInvoice(invoice);
		        System.out.println("Invoice generated successfully!");
		        System.out.println("Invoice ID: " + savedInvoice.getId());
		        System.out.println("Total Amount: ₹" + totalAmount);
		    }
		    public static void recordPayment() {
		        System.out.println("\n--- Record Payment ---");
		        System.out.print("Enter Invoice ID: ");
		        Long invoiceId = sc.nextLong();
		        sc.nextLine();
		        Invoice invoice = invoiceService.getInvoice(invoiceId);
		        if (invoice == null) {
		            System.out.println("Invoice not found.");
		            return;
		        }
		        System.out.print("Enter paid amount: ");
		        double paidAmount = sc.nextDouble();
		        sc.nextLine();
		        System.out.print("Enter payment date: ");
		        String date = sc.nextLine();
		        System.out.print("Enter payment mode: ");
		        String mode = sc.nextLine();
		        System.out.print("Enter payment status: ");
		        String status = sc.nextLine();
		        Payment payment = new Payment(
		                invoice,
		                paidAmount,
		                date,
		                mode,
		                status
		        );
		        Payment savedPayment =paymentService.savePayment(payment);
		        System.out.println("Payment recorded successfully!");
		        System.out.println("Payment ID: " + savedPayment.getId());
		        double outstanding =invoice.getTotalAmount() - paidAmount;
		        System.out.println("Outstanding Amount: ₹" + outstanding);
		    }
		    public static void viewCustomer() {
		        System.out.println("\n--- View Customer ---");
		        System.out.print("Enter Customer ID: ");
		        Long id = sc.nextLong();
		        sc.nextLine();
		        Customer customer = customerService.getCustomer(id);
		        if (customer == null) {
		            System.out.println("Customer not found.");
		            return;
		        }
		        System.out.println("Customer ID : " + customer.getId());
		        System.out.println("Name        : " + customer.getName());
		        System.out.println("Phone       : " + customer.getPhone_No());
		        System.out.println("Email       : " + customer.getEmail());
		        System.out.println("Address     : " + customer.getAddress());
		    }
		    public static void viewJobOrder() {
		        System.out.println("\n--- View Job Order ---");
		        System.out.print("Enter Job Order ID: ");
		        Long id = sc.nextLong();
		        sc.nextLine();
		        JobOrder jobOrder = jobOrderService.getJobOrder(id);
		        if (jobOrder == null) {
		            System.out.println("Job Order not found.");
		            return;
		        }
		        System.out.println("Job Order ID : " + jobOrder.getId());
		        System.out.println("Product     : " + jobOrder.getProductName());
		        System.out.println("Quantity    : " + jobOrder.getQuantity());
		        System.out.println("Rate        : ₹" + jobOrder.getRate());
		        System.out.println("Status      : " + jobOrder.getStatus());
		        if (jobOrder.getCustomer() != null) {
		            System.out.println( "Customer    : " +jobOrder.getCustomer().getName());
		        }
		    }
		    public static void viewProduction() {
		        System.out.println("\n--- View Production ---");
		        System.out.print("Enter Production ID: ");
		        Long id = sc.nextLong();
		        sc.nextLine();
		        Production production =productionService.getProduction(id);
		        if (production == null) {
		            System.out.println("Production record not found.");
		            return;
		        }
		        System.out.println("Production ID : " + production.getId());
		        System.out.println("Produced      : " +production.getProductQuantity());
		        System.out.println( "Pending       : " +production.getPendingQuantity());
		        System.out.println("Date          : " +production.getProductionDate());
		        System.out.println("Remarks       : " +production.getRemarks());
		    }
		    public static void viewInvoice() {
		        System.out.println("\n--- View Invoice ---");
		        System.out.print("Enter Invoice ID: ");
		        Long id = sc.nextLong();
		        sc.nextLine();
		        Invoice invoice = invoiceService.getInvoice(id);
		        if (invoice == null) {
		            System.out.println("Invoice not found.");
		            return;
		        }
		        System.out.println("Invoice ID     : " + invoice.getId());
		        System.out.println("Billed Quantity: " +invoice.getBilledQuantity());
		        System.out.println("Total Amount   : ₹" +invoice.getTotalAmount());
		        System.out.println("Invoice Date   : " +invoice.getInvoiceDate());
		        System.out.println("Status         : " +invoice.getInvoiceStatus());
		    }
		    public static void updateCustomer() {
		        System.out.println("\n--- Update Customer ---");
		        System.out.print("Enter Customer ID: ");
		        Long id = sc.nextLong();
		        sc.nextLine();
		        Customer customer = customerService.getCustomer(id);
		        if (customer == null) {
		            System.out.println("Customer not found.");
		            return;
		        }
		        System.out.print("Enter new name: ");
		        customer.setName(sc.nextLine());
		        System.out.print("Enter new phone: ");
		        customer.setPhone_No(sc.nextLine());
		        System.out.print("Enter new email: ");
		        customer.setEmail(sc.nextLine());
		        System.out.print("Enter new address: ");
		        customer.setAddress(sc.nextLine());
		        customerService.updateCustomer(customer);
		        System.out.println("Customer updated successfully!");
		    }
		    public static void deleteCustomer() {
		        System.out.println("\n--- Delete Customer ---");
		        System.out.print("Enter Customer ID: ");
		        Long id = sc.nextLong();
		        sc.nextLine();
		        Customer customer = customerService.getCustomer(id);
		        if (customer == null) {
		            System.out.println("Customer not found.");
		            return;
		        }
		        System.out.print("Are you sure you want to delete this customer? (yes/no): ");
		        String confirmation = sc.nextLine();
		        if (confirmation.equalsIgnoreCase("yes")) {
		            customerService.deleteCustomer(id);
		            System.out.println("Customer deleted successfully!");
		        } else {
		            System.out.println("Delete cancelled.");
		        }
		    }
}
