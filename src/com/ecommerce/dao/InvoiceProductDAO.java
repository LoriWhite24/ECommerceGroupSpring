package com.ecommerce.dao;

import java.util.List;

import com.ecommerce.beans.InvoiceProduct;

/**
 * The DAO for invoice_product.
 * @author Lori White
 * @version v2 (11/12/2020)
 */
public interface InvoiceProductDAO {
	/**
	 * Retrieves an invoice-product by id.
	 * @param id the invoice-product id to search for
	 * @return InvoiceProduct - the invoice-product found by id
	 */
	public InvoiceProduct getById(Integer id);
	/**
	 * Retrieves a list of invoice-product objects by an invoice id.
	 * @param invoiceId the invoice id to search by
	 * @return List - the list of invoice-product objects by an invoice id
	 */
	public List<InvoiceProduct> getByInvoiceId(Integer invoiceId);
	/**
	 * Adds an invoice linked to a product.
	 * @param invoiceProduct the invoice linked to a product
	 * @return boolean - whether the added invoice linked to a product was added
	 */
	public boolean add(InvoiceProduct invoiceProduct);
	/**
	 * Updates an invoice-product.
	 * @param invoiceProduct the invoice-product to update
	 * @param column the specific column to update or if null update all
	 * @return boolean - whether the invoice-product was updated
	 */
	public boolean update(InvoiceProduct invoiceProduct, String column);
	/**
	 * Updates an invoice-product based on giving the ok on a requested return.
	 * @param invoiceProduct the invoice-product to update
	 * @return boolean - whether the invoice-product was updated
	 */
	public boolean requestedReturnValidated(InvoiceProduct invoiceProduct);
}
