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
        coupon.setCompany(company);
        company.setCoupons(List.of(coupon));
        companyRepository.save(this.company);
    }

    @Override
    public Coupon getSingleCoupon(int couponId) {
        return null;
    }

    @Override
    public void updateCoupon(int couponId, Coupon couponToUpdate) throws CouponException {

    }

    @Override
    public void deleteCoupon(int couponId) throws Exception {
        Coupon coupon = couponRepository.findById(couponId).orElseThrow(
                () -> new CouponException(CouponMsg.COUPON_ID_NO_EXISTS, String.valueOf(couponId)));

        if (coupon.getCompany().getId() != company.getId()) {
            throw new CompanyException(CompanyMsg.COMPANY_CANNO_DELETE_OTHER_COMPANY_COUPON,
                    company.getId() + "-" + coupon.getCompany().getId());
        }
        couponRepository.deleteById(couponId);
    }

    @Override
    public List<Coupon> getAllCoupons() {
        return null;
    }

    @Override
    public List<Coupon> getAllCoupons(Category category) {
        return null;
    }

    @Override
    public List<Coupon> getAllCoupons(double maxPrice) {
        return null;
    }

    @Override
    public Company getCompanyDetails() {
        return companyRepository.findById(company.getId()).orElseThrow();
    }

}
