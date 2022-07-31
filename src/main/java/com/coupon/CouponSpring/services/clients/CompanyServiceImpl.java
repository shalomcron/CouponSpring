package com.coupon.CouponSpring.services.clients;

import com.coupon.CouponSpring.bean.Category;
import com.coupon.CouponSpring.bean.Company;
import com.coupon.CouponSpring.bean.Coupon;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Service()
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CompanyServiceImpl extends ClientService implements CompanyService {

    private Company company;

    @Override
    public boolean login(String email, String password) {
        try {
            this.company = companyRepository.findByEmailAndPassword(email, password)
                    .orElseThrow();
            System.out.println("login this.company : " + this.company);
            return true;
        } catch (Exception e) {
            System.out.println("E" + e.getMessage());
            return false;
        }
    }

    @Override
    public void addCoupon(Coupon coupon) throws CouponException {
        if (couponRepository.existsByTitleAndCompany(coupon.getTitle(), company)) {
            throw new CouponException(CouponMsg.COUPON_TITLE_EXIST_SAME_COMPANY, coupon.getTitle());
        }
        System.out.println("addCoupon company:" + company);
        coupon.setCompany(company);
        company.setCoupons(List.of(coupon));
        companyRepository.save(this.company);
    }

    @Override
    public Coupon getSingleCoupon(int couponId) {
        return couponRepository.findByIdAndCompany(couponId, company);
    }

    @Override
    public void updateCoupon(int couponId, Coupon couponToUpdate) throws CouponException {
        if (couponId != couponToUpdate.getId()) {
            throw new CouponException(CouponMsg.COUPON_ID_CANNOT_BE_CHANGED,
                    couponId + "-" + couponToUpdate.getId());
        }
        if (company.getId() != couponToUpdate.getCompany().getId()) {
            throw new CouponException(CouponMsg.COUPON_COMPANY_ID_CANNOT_BE_CHANGED,
                    company.getId() + "-" + couponToUpdate.getCompany().getId());
        }
        couponRepository.save(couponToUpdate);
    }

    @Override
    public void deleteCoupon(int couponId) {
        couponRepository.deleteById(couponId);
    }

    @Override
    public List<Coupon> getAllCoupons() {
        return couponRepository.findByCompany(company);
    }

    @Override
    public List<Coupon> getAllCoupons(Category category) {
        return couponRepository.findByCompanyAndCategory(company, category);
    }

    @Override
    public List<Coupon> getAllCoupons(double maxPrice) {
        return couponRepository.findByCompanyAndMaxPrice(company.getId(), maxPrice);
    }

    @Override
    public Company getCompanyDetails() {
        return company;
    }

}
