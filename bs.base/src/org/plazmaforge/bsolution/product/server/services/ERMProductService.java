package org.plazmaforge.bsolution.product.server.services;

import java.util.List;
import org.plazmaforge.bsolution.organization.server.services.AbstractOrganizableService;
import org.plazmaforge.bsolution.product.common.beans.Product;
import org.plazmaforge.bsolution.product.common.beans.ProductInstance;
import org.plazmaforge.bsolution.product.common.beans.ProductPrice;
import org.plazmaforge.bsolution.product.common.beans.ProductUnit;
import org.plazmaforge.bsolution.product.common.services.ProductService;
import org.plazmaforge.framework.core.exception.DAOException;
import org.plazmaforge.framework.core.exception.FinderException;

public class ERMProductService extends AbstractOrganizableService<Product, Integer> implements ProductService {

    protected Class getEntityClass() {
        return Product.class;
    }

    public List<ProductUnit> findUnitByProductId(Integer productId) throws DAOException, FinderException {
        return getEntityManager().findAll(ProductUnit.class,  "product.id", productId);
    }

    public List<ProductPrice> findPriceByProductId(Integer productId) throws DAOException, FinderException {
        return getEntityManager().findAll(ProductPrice.class, "product.id", productId);
    }

    public List<ProductInstance> findInstanceByProductId(Integer productId) throws DAOException, FinderException {
	return getEntityManager().findAll(ProductInstance.class, "product.id", productId);
    }
}
