package com.coupon.CouponSpring.services.clients;

import com.coupon.CouponSpring.bean.Category;
import com.coupon.CouponSpring.bean.Company;
import com.coupon.CouponSpring.bean.Coupon;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl extends ClientService implements CompanyService {

    private Company company;

    @Override
    public boolean login(String email, String password) {
        try {
            this.company = companyRepository.findByEmailAndPassword(email, password)
                    .orElseThrow();
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
        // TODO: delete customers coupon
        couponRepository.deleteById(couponId);
    }

    @Override
    public List<Coupon> getAllCoupons(Company company) {
        return companyRepository.findByCompany(company);
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
        return null;
    }

}
