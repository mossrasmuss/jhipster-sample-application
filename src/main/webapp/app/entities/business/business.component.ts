import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

import { IBusiness } from 'app/shared/model/business.model';
import { BusinessService } from './business.service';
import { BusinessDeleteDialogComponent } from './business-delete-dialog.component';

@Component({
  selector: 'jhi-business',
  templateUrl: './business.component.html',
})
export class BusinessComponent implements OnInit, OnDestroy {
  businesses?: IBusiness[];
  eventSubscriber?: Subscription;

  constructor(protected businessService: BusinessService, protected eventManager: JhiEventManager, protected modalService: NgbModal) {}

  loadAll(): void {
    this.businessService.query().subscribe((res: HttpResponse<IBusiness[]>) => (this.businesses = res.body || []));
  }

  ngOnInit(): void {
    this.loadAll();
    this.registerChangeInBusinesses();
  }

  ngOnDestroy(): void {
    if (this.eventSubscriber) {
      this.eventManager.destroy(this.eventSubscriber);
    }
  }

  trackId(index: number, item: IBusiness): number {
    // eslint-disable-next-line @typescript-eslint/no-unnecessary-type-assertion
    return item.id!;
  }

  registerChangeInBusinesses(): void {
    this.eventSubscriber = this.eventManager.subscribe('businessListModification', () => this.loadAll());
  }

  delete(business: IBusiness): void {
    const modalRef = this.modalService.open(BusinessDeleteDialogComponent, { size: 'lg', backdrop: 'static' });
    modalRef.componentInstance.business = business;
  }
}
