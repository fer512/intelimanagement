package ar.com.intelimanagement.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.jhipster.service.QueryService;

import ar.com.intelimanagement.domain.Booking;
import ar.com.intelimanagement.domain.*; // for static metamodels
import ar.com.intelimanagement.repository.BookingRepository;
import ar.com.intelimanagement.service.dto.BookingCriteria;

import ar.com.intelimanagement.service.dto.BookingDTO;
import ar.com.intelimanagement.service.mapper.BookingMapper;

/**
 * Service for executing complex queries for Booking entities in the database.
 * The main input is a {@link BookingCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link BookingDTO} or a {@link Page} of {@link BookingDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class BookingQueryService extends QueryService<Booking> {

    private final Logger log = LoggerFactory.getLogger(BookingQueryService.class);

    private final BookingRepository bookingRepository;

    private final BookingMapper bookingMapper;

    public BookingQueryService(BookingRepository bookingRepository, BookingMapper bookingMapper) {
        this.bookingRepository = bookingRepository;
        this.bookingMapper = bookingMapper;
    }

    /**
     * Return a {@link List} of {@link BookingDTO} which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<BookingDTO> findByCriteria(BookingCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<Booking> specification = createSpecification(criteria);
        return bookingMapper.toDto(bookingRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link BookingDTO} which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<BookingDTO> findByCriteria(BookingCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Booking> specification = createSpecification(criteria);
        return bookingRepository.findAll(specification, page)
            .map(bookingMapper::toDto);
    }

    /**
     * Function to convert BookingCriteria to a {@link Specification}
     */
    private Specification<Booking> createSpecification(BookingCriteria criteria) {
        Specification<Booking> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildSpecification(criteria.getId(), Booking_.id));
            }
            if (criteria.getIdTransaction() != null) {
                specification = specification.and(buildStringSpecification(criteria.getIdTransaction(), Booking_.idTransaction));
            }
            if (criteria.getIdReserveLocatorJuniper() != null) {
                specification = specification.and(buildStringSpecification(criteria.getIdReserveLocatorJuniper(), Booking_.idReserveLocatorJuniper));
            }
            if (criteria.getIdReserveLocatorExternal() != null) {
                specification = specification.and(buildStringSpecification(criteria.getIdReserveLocatorExternal(), Booking_.idReserveLocatorExternal));
            }
            if (criteria.getDetail() != null) {
                specification = specification.and(buildStringSpecification(criteria.getDetail(), Booking_.detail));
            }
            if (criteria.getCompanyId() != null) {
                specification = specification.and(buildReferringEntitySpecification(criteria.getCompanyId(), Booking_.company, Company_.id));
            }
        }
        return specification;
    }

}
