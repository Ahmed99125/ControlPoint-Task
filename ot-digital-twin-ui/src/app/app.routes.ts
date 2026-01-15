import { Routes } from '@angular/router';
import { AssetListComponent } from './components/asset-list/asset-list';
import { AssetDetailsComponent } from './components/asset-details/asset-details';

export const routes: Routes = [
  { path: '', component: AssetListComponent, pathMatch: 'full' },
  { path: 'assets/:id', component: AssetDetailsComponent },
  { path: '**', redirectTo: '' }
];